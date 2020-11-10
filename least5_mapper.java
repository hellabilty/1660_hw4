import java.io.*; 
import org.apache.hadoop.io.Text; 
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.mapreduce.Mapper; 
  
public class least5_mapper extends Mapper<Object, 
                              Text, LongWritable, Text> { 
  
    // data format  => voteSubject    
    // numVotes   (tab seperated) 
    @Override
    public void map(Object key, Text value,  
       Context context) throws IOException,  
                      InterruptedException 
    { 
  
        String[] tokens = value.toString().split("\t"); 
  
        String voteSubject = tokens[0]; 
        long numVotes = Long.parseLong(tokens[1]); 
  
        context.write(new LongWritable(numVotes), 
                              new Text(voteSubject)); 
    } 
} 