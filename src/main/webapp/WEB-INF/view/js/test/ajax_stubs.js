function stubing_correct_status(status,returnData){
	    sinon.stub($,'ajax',function(options){
          	  var deferred = $.Deferred();
          	      if(options.success) 
          	      	  deferred.done(options.success( returnData,status));
          	      if(options.error) 
          	      	  deferred.fail(options.error);
                  deferred.success = deferred.done;
                  deferred.error = deferred.fail;
          	      return deferred;
          	  }
          );
}
