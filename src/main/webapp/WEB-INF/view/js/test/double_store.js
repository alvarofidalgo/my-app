function Double_store(resumes,errors){
   this._resumes = resumes;
   this._errors = errors;
}


Double_store.prototype.insertTransaction = function(data,callback){
	                  callback(this._resumes);
	    }

Double_store.prototype.errorsInTransaction = function(data,callback){
	                  callback(this._errors);
     }