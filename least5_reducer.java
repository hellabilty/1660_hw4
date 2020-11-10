import java.io.*; 
import org.apache.hadoop.io.Text; 
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.mapreduce.Reducer; 
  
public class least5_reducer extends Reducer<LongWritable, 
                                      Text, LongWritable, Text> { 
  
    static int count; 
  
    @Override
    public void setup(Context context) throws IOException, 
                                     InterruptedException 
    { 
        count = 0; 
    } 
  
    @Override
    public void reduce(LongWritable key, Iterable<Text> values, 
      Context context) throws IOException, InterruptedException 
    { 
  
        long numVotes = key.get(); 
  
        String movie_name = null; 
  
        for (Text val : values)  
        { 
            movie_name = val.toString(); 
        } 
  
        // we just write 10 records as output 
        if (count < 5) 
        { 
            context.write(new LongWritable(numVotes), 
                                  new Text(voteSubject)); 
            count++; 
        } 
    } 
} 