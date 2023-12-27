package com.example.springcrud.exception;

public class usernotfound extends RuntimeException {
   public usernotfound(Long id)
   {
       super("No Such User exists"+id);
   }
}
