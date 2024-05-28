package com.sample.Exception;

public class UserNotFound extends  Exception{

    UserNotFound(String str,int id){
         super("user not found with id="+id);
    }
    
}
