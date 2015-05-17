"use strict"
var jsonCorrect ={userId: "134256", 
           currencyFrom: "EUR", 
           currencyTo: "GBP", 
           amountSell: 1000, 
           amountBuy: 747.10, 
           rate: 0.7471, 
           timePlaced : "", 
           originatingCountry : "FR"};

var jsonIncorrect = {userId: "", 
           currencyFrom: "EUR", 
           currencyTo: "GBP", 
           amountSell: 1000, 
           amountBuy: 747.10, 
           rate: 0.7471, 
           timePlaced : "", 
           originatingCountry : "FR"};


var jsons = [jsonCorrect,jsonIncorrect]

    function parserTime(time){
       if (time.length===1)
          time = '0'+time;
        return time;
    }

    function generateHour(){
      var date = new Date(),hour =date.getHours()+'',minutes=date.getMinutes()+'',seconds=date.getSeconds()+'';
          return parserTime(hour)+':'+parserTime(minutes)+':'+parserTime(seconds);
    }




function jsonToSendGenerator(){

    var times =0,
        parameters=['userId',
                    'currencyFrom',
                    'currencyTo',
                    'amountSell',
                    'amountBuy',
                    'rate',
                    'timePlaced',
                    'originatingCountry'],parameterIndex=0;
        return {buildJSON:function(){
                   var timesToUse = times%2,json = jsons[timesToUse];
                       json['timePlaced'] ="24-JAN-15 "+generateHour();
                       if (timesToUse==1){
                             json[parameters[parameterIndex%7]]="";
                             parameterIndex++;
                             if (parameterIndex%7==0){
                               console.log('refresca');
                                jsons[1]={userId: "", 
                                           currencyFrom: "EUR", 
                                           currencyTo: "GBP", 
                                           amountSell: 1000, 
                                           amountBuy: 747.10, 
                                           rate: 0.7471, 
                                           timePlaced : "", 
                                           originatingCountry : "FR"}
                             }
                       }
                       times++;
                       
                       return json;
                      
               }
     }

}