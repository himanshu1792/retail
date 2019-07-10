package com.retail.discounts;

import java.time.Duration;
import java.util.Arrays;

import org.apache.kafka.common.metrics.stats.Count;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Aggregator;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Initializer;
import org.apache.kafka.streams.kstream.KGroupedStream;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.Reducer;
import org.apache.kafka.streams.kstream.TimeWindowedKStream;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.apache.kafka.streams.kstream.Windowed;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class App1 {
  @SuppressWarnings("unchecked")
  @Bean("app1StreamTopology")
  public KStream<String, String> startProcessing(@Qualifier("app1StreamBuilder") StreamsBuilder builder) {

	  
    final KStream<String, String> printValue = builder.stream("tutorialspoint1", Consumed.with(Serdes.String(), Serdes.String()));
    
    KStream<Windowed<String>, String> newStream = printValue.groupByKey().windowedBy(TimeWindows.of(10000L)
            .advanceBy(10000L))
    .reduce(new Reducer<String>() {

		@Override
		public String apply(String value1, String value2) {
			// TODO Auto-generated method stub
			return value2;
		}
	}).toStream();
    
   /* KStream<String, Long> wordCounts = printValue.flatMapValues(val->Arrays.asList(val.toLowerCase().split("\\W+"))).groupByKey().count().toStream()
    		;
    
    wordCounts.foreach((key,value)->{
    	
    	System.out.println(key+" key");
    	System.out.println(value+" value");
    });*/
//    KStream<String, Long> wordCounts = printValue.flatMapValues(val->Arrays.asList(val.toLowerCase().split("\\W+"))).groupBy((key,value)->value).count().toStream();
    
    /*TimeWindowedKStream<String,String> timeWindowed = printValue.groupByKey().windowedBy(TimeWindows.of(10000L)
            .advanceBy(10000L));
    
    KTable<Windowed<String>, String> results = timeWindowed.aggregate(null, null);

 // This converstion causing changelog to output. Instead use next line.
 KStream<String, Aggregat> aggregationMessageKStream = results.toStream((key,value) -> key.toString().mapValues(this::convertToAggregationMessage).filter((k, v) -> v != null));*/
                 
    /*Duration windowSizeMs = Duration.ofMinutes(5);
    TimeWindows.of(windowSizeMs.getSeconds()).advanceBy(windowSizeMs.getSeconds());
*/
    // The above is equivalent to the following code:
    //TimeWindows.of(windowSizeMs).advanceBy(windowSizeMs);
    
    
   /* TimeWindowedKStream<String,String> timeWindowed = printValue.groupByKey().windowedBy(TimeWindows.of(10000L)
            .advanceBy(10000L));
    timeWindowed.aggregate(initializer, aggregator)*/
    
    /*KStream<Windowed<String>, String> newStream =  printValue.groupByKey().windowedBy(TimeWindows.of(1000L).advanceBy(1000L))
    		.aggregate(new Initializer<Long>() {  initializer 
    		      @Override
    		      public Long apply() {
    		        return 0L;
    		      }
    		    },
    		    new Aggregator<byte[], String, Long>() {  adder 
    		      @Override
    		      public Long apply(byte[] aggKey, String newValue, Long aggValue) {
    		        return aggValue + newValue.length();
    		      }
    		    },
    		    new Aggregator<byte[], String, Long>() {  subtractor 
    		      @Override
    		      public Long apply(byte[] aggKey, String oldValue, Long aggValue) {
    		        return aggValue - oldValue.length();
    		      }
    		    },
    		    Materialized.as("aggregated-stream-store")
    		        .withValueSerde(Serdes.Long()))*/
   /* KTable < Windowed < String > , CourseStatistic > windowedCourseStatisticKTable = validReviews.filter((k, review) - > !isReviewExpired(review)).groupByKey().aggregate(this::emptyStats, this::reviewAggregator, timeWindows, courseStatisticSpecificAvroSerde);*/
   
    /*KStream<String, String> newprintValue = printValue.groupByKey().aggregate(String::new, (k,v,msg)->msg,
    		TimeWindows.of(5000).advanceBy(1000), Serdes.String(),"windowTest").toStream();*/
    
    newStream.foreach((k,v)->
    {
    	
    	System.out.println(k+" key");
    	System.out.println(v+" value");
    });
    
    printValue.map((key, value) -> { 
    	
    	/*System.out.println("key :"+key);
    	System.out.println("value :"+value);
*/    	
      return KeyValue.pair(key, value.toUpperCase());
    }).to("streamTest"); // send downstream to another topic

    return printValue;
  }
  
  
  

}

