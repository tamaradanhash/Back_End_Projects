package at.nacs.ex2amazinghelloworld;

import lombok.Value;
import org.springframework.stereotype.Component;
@Value
@Component
public class Hello {
   public String getName(){
       return "Hello";
   }
}
