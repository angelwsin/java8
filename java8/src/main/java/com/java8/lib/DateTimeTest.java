package com.java8.lib;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZonedDateTime;

/**
 * Java 8吸收了Joda-Time 的精华。新的java.time包包含了所有关于日期、时间、日期时间、时区、
 * Instant（跟日期类似但精确到纳秒）、duration（持续时间）和时钟操作的类。
 * 设计这些API的时候很认真地考虑了这些类的不变性（从java.util.Calendar吸取的痛苦教训）。
 * 如果需要修改时间对象，会返回一个新的实例。
 * @author angel
 *
 */
public class DateTimeTest {

	
	public static void main(String[] args) {
		//第一个类是Clock，Clock使用时区来访问当前的instant, date和time。
		//Clock类可以替换 System.currentTimeMillis() 和 TimeZone.getDefault().
		//通用协调时(UTC, Universal Time Coordinated)。UTC与格林尼治平均时(GMT, Greenwich Mean Time)一样，
		//都与英国伦敦的本地时相同。UTC与GMT含义完全相同
		Clock lock =  Clock.systemUTC();
		System.out.println(lock.instant());
		System.out.println(lock.millis());
	
		//LocalTime和LocalDate。LocalDate只保存有ISO-8601日期系统的日期部分，有时区信息，相应地，
		//LocalTime只保存ISO-8601日期系统的时间部分，没有时区信息。
		//LocalDate和LocalTime都可以从Clock对象创建
		LocalDate lc = LocalDate.now();
		LocalDate lcz = LocalDate.now(lock);
		System.out.println(lc);
		System.out.println(lcz);
		LocalTime lt = LocalTime.now();
		LocalTime ltz = LocalTime.now(lock);
		System.out.println(lt);
		System.out.println(ltz);
		//LocalDateTime类合并了LocalDate和LocalTime，它保存有ISO-8601日期系统的日期和时间，但是没有时区信息
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		//如果您需要一个类持有日期时间和时区信息，可以使用ZonedDateTime，
		//它保存有ISO-8601日期系统的日期和时间，而且有时区信息
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt);
		//Duration类，Duration持有的时间精确到纳秒。它让我们很容易计算两个日期中间的差异
		final LocalDateTime from = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
		final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );
		 
		final Duration duration = Duration.between( from, to );
		System.out.println( "Duration in days: " + duration.toDays() );
		System.out.println( "Duration in hours: " + duration.toHours() );
	}
}
