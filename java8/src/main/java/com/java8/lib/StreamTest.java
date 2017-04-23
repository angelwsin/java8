package com.java8.lib;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//新增加的Stream API (java.util.stream)引入了在Java里可以工作的函数式编程
//Stream操作被分为中间操作和终点操作。
//中间操作返回一个新的Stream。这些中间操作是延迟的，执行一个中间操作比如filter实际上不会真的做过滤操作，
//而是创建一个新的Stream，当这个新的Stream被遍历的时候，它里头会包含有原来Stream里符合过滤条件的元素。

//终点操作比如说forEach或者sum会遍历Stream从而产生最终结果或附带结果。终点操作执行完之后，
//Stream管道就被消费完了，不再可用。在几乎所有的情况下，终点操作都是即时完成对数据的遍历操作
public class StreamTest {
	
	static enum Stat{
		OPEN,
		CLOSE;
	}
	
	static class Task{
		private Stat stat;
		private Integer points;
		
		
		public Task(Stat stat, Integer points) {
			super();
			this.stat = stat;
			this.points = points;
		}
		public Stat getStat() {
			return stat;
		}
		public void setStat(Stat stat) {
			this.stat = stat;
		}
		public Integer getPoints() {
			return points;
		}
		public void setPoints(Integer points) {
			this.points = points;
		}
		@Override
		public String toString() {
			return "Task [stat=" + stat + ", points=" + points + "]";
		}
		
	}

	public static void main(String[] args) {
		Collection<Task> tasks  = Arrays.asList(new Task(Stat.OPEN,5),new Task(Stat.OPEN,13),new Task(Stat.CLOSE,8));
		//统计和通常做法 foreach 迭代
		//使用Stream
		//Stream是多个元素的序列，支持串行和并行操作
		int total = tasks.stream()
		.filter(task->task.getStat()==Stat.OPEN)
		.mapToInt(Task::getPoints)
		.sum();
		System.out.println(total);
		//Stream创造性地支持并行(parallel)处理
		//底层 ForkJoinTask   类似 map reduce
		//Map（映射）"和"Reduce（归约）"
		//指定一个Map（映射）函数，用来把一组键值对映射成一组新的键值对，指定并发的Reduce（归约）函数
		double totalPoints = tasks.stream()
		.parallel()
		.map(task->task.getPoints())
		.reduce(0, Integer::sum);//T result = identity;  每一个forkjointask的起始值
		System.out.println(totalPoints );
		
		//我们需要按照某种准则来对集合中的元素进行分组。Stream也可以处理这样的需求
		Map< Stat, List< Task > > map = tasks.stream()
		 .collect(Collectors.groupingBy(Task::getStat));
		System.out.println(map);
		//计算整个集合中每个task分数（或权重）的平均值来结束task
		Collection< String > result =tasks.stream()
		.mapToInt(Task::getPoints)//IntStream
		.asLongStream() //LongStream
		.mapToDouble(ponits->ponits/totalPoints )//doubleSteam
		.boxed()//Stream<Double>
		.mapToLong(weight->(long)(weight*100))//LongSteam
		.mapToObj(percentage -> percentage + "%")//Stream<String>
		.collect(Collectors.toList());//List<String>
		System.out.println(result);
	}
	
	/**
	 * Stream操作被分为中间操作和终点操作
	 * Collection   的子类实现spliterator() 定制自己的Spliterator 拆分器 forkjointask 的任务
	 * StreamSupport.stream(spliterator(), false)   参数parallel 是否并行 使用forkjointask
	 * Spliterator.trySplit()  拆分规则
	 * Spliterator.characteristics() 拆分器的特征   (特征的定义在Spliterator中如有序Spliterator.SORTED)
	 * ReferencePipeline  实现Stream 作为 中间管道  以链表的形式串起整个Stream
	 * Collection.stream()创造 Head Pipeline --ReferencePipeline.Head Stream
	 * 接下来创建不同的Stream 
	 * 与 Stream 配套使用的 Sink(退去)
	 * 根据Stream链表  创建 Sink链表 执行Stream指定的action   数据在Stream指定的action中流转处理

     所有的AbstractPipeline 使用链表串联起来
	 */
}
