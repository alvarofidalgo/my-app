"use strict"
function ResumesView(viewElements){
    var listErrors = viewElements['errors'],
        listResumes = viewElements['resumes'];
    function removeAllChildsOf(element){
                while (element.firstChild) {
                   element.removeChild(element.firstChild);
                 }
    }
     return {cleanErrors:function(){
                 removeAllChildsOf(listErrors);
             },
             showError:function(error){
               var newItem = document.createElement("LI"),       
                    textnode = document.createTextNode(error);
                    newItem.appendChild(textnode);
                    listErrors.insertBefore(newItem, listErrors.childNodes[0]);
             },
             clearResumeTransactions:function(){
                removeAllChildsOf(listResumes);
             },
             showResumeTransaction:function(resumeTransaction){
                var newItem = document.createElement("LI"),
                    textnode = document.createTextNode('currencyFrom :'+resumeTransaction['currencyFrom']+' '+
                                                        'currencyTo :' +resumeTransaction['currencyTo']+' '+
                                                        'Date transaction :'+resumeTransaction['otherFormatDate']);
                    newItem.appendChild(textnode);
                    listResumes.insertBefore(newItem, listResumes.childNodes[0]);
             }


     }
}