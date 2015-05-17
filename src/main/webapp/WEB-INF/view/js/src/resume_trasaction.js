"use strict"
function ResumeTransaction(callbackRestore,callbackPrint){

	  return {forEach:function(data){
	  	            if (data.length>0)
	  	            	callbackRestore();
                    for (var index = 0; index<data.length;index++)
                    	callbackPrint(data[index]);
	         }

	  }
}