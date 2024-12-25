/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import static java.lang.Math.round;
import java.time.LocalTime;

/**
 *
 * @author josue
 */
public class Hora {
    
    private LocalTime hora;
    private String error;
    
    public Hora(boolean now){
        
        if(now){
            this.hora = LocalTime.now();
        } else {
            this.hora = LocalTime.of(0, 0, 0);
        }
        
    }//Hora(boolean now)
    
    public Hora(LocalTime hora){
        this.hora = hora;
    }
    
    public Hora(String time){
        
        String tema = "";
            
        int hour = 0;
        int minute = 0;
        int second = 0;
        
        try{
            if(time.matches("[0-9]{1}[-][0-9]{2}[-][0-9]{2}") || time.matches("[0-9]{1}[:][0-9]{2}[:][0-9]{2}")){
                
                for(int i = 0; i < 8; i++){
                    
                    int num;
                    
                    switch(time.charAt(i)){
                        
                        case '1':
                        num = 1;
                        break;
                        
                        case '2':
                        num = 2;
                        break;
                        
                        case '3':
                        num = 3;
                        break;
                        
                        case '4':
                        num = 4;
                        break;
                        
                        case '5':
                        num = 5;
                        break;
                        
                        case '6':
                        num = 6;
                        break;
                        
                        case '7':
                        num = 7;
                        break;
                        
                        case '8':
                        num = 8;
                        break;
                        
                        case '9':
                        num = 9;
                        break;
                        
                        default:
                        num = 0;
                        break;
                        
                    }//switch(time.charAt(i))
                    
                    switch(i+1){
                        
                        case 1:
                        hour = num;
                        break;
                        
                        case 3:
                        minute = num;
                        break;
                        
                        case 4:
                        minute = minute*10 + num;
                        break;
                        
                        case 6:
                        second = num;
                        break;
                        
                        case 7:
                        second = second*10 + num;
                        break;
                        
                    }//switch(i+1)
                    
                }//for(int i = 0; i < 8; i++)
                
                this.hora = LocalTime.of(hour, minute, second);
                
            } else if(time.matches("[0-9]{1}[:][0-9]{2}") || time.matches("[0-9]{1}[-][0-9]{2}")){
                
                for(int i = 0; i < 5; i++){
                    
                    int num;
                    
                    switch(time.charAt(i)){
                        
                        case '1':
                        num = 1;
                        break;
                        
                        case '2':
                        num = 2;
                        break;
                        
                        case '3':
                        num = 3;
                        
                        case '4':
                        num = 4;
                        break;
                        
                        case '5':
                        num = 5;
                        break;
                        
                        case '6':
                        num = 6;
                        break;
                        
                        case '7':
                        num = 7;
                        break;
                        
                        case '8':
                        num = 8;
                        break;
                        
                        case '9':
                        num = 9;
                        break;
                        
                        default:
                        num = 0;
                        break;
                        
                    }//switch(time.charAt(i))
                    
                    switch(i+1){
                        
                        case 1:
                        hour = num;
                        break;
                        
                        case 3:
                        minute = num;
                        break;
                        
                        case 4:
                        minute = minute*10 + num;
                        break;
                        
                    }//switch(i+1)
                    
                }//for(int i = 0; i < 8; i++)
                
                this.hora = LocalTime.of(hour, minute, 0);
                
            } else if(time.matches("[0-9]{2}[-][0-9]{2}[-][0-9]{2}") || time.matches("[0-9]{2}[:][0-9]{2}[:][0-9]{2}")){
                
                for(int i = 0; i < 8; i++){
                    
                    int num;
                    
                    switch(time.charAt(i)){
                        
                        case '1':
                        num = 1;
                        break;
                        
                        case '2':
                        num = 2;
                        break;
                        
                        case '3':
                        num = 3;
                        break;
                        
                        case '4':
                        num = 4;
                        break;
                        
                        case '5':
                        num = 5;
                        break;
                        
                        case '6':
                        num = 6;
                        break;
                        
                        case '7':
                        num = 7;
                        break;
                        
                        case '8':
                        num = 8;
                        break;
                        
                        case '9':
                        num = 9;
                        break;
                        
                        default:
                        num = 0;
                        break;
                        
                    }//switch(time.charAt(i))
                    
                    switch(i+1){
                        
                        case 1:
                        hour = num;
                        break;
                        
                        case 2:
                        hour = hour*10 + num;
                        break;
                        
                        case 4:
                        minute = num;
                        break;
                        
                        case 5:
                        minute = minute*10 + num;
                        break;
                        
                        case 7:
                        second = num;
                        break;
                        
                        case 8:
                        second = second*10 + num;
                        break;
                        
                    }//switch(i+1)
                    
                }//for(int i = 0; i < 8; i++)
                
                this.hora = LocalTime.of(hour, minute, second);
                
            } else if(time.matches("[0-9]{2}[-][0-9]{2}") || time.matches("[0-9]{2}[:][0-9]{2}")){
                
                for(int i = 0; i < 5; i++){
                    
                    int num;
                    
                    switch(time.charAt(i)){
                        
                        case '1':
                        num = 1;
                        break;
                        
                        case '2':
                        num = 2;
                        break;
                        
                        case '3':
                        num = 3;
                        
                        case '4':
                        num = 4;
                        break;
                        
                        case '5':
                        num = 5;
                        break;
                        
                        case '6':
                        num = 6;
                        break;
                        
                        case '7':
                        num = 7;
                        break;
                        
                        case '8':
                        num = 8;
                        break;
                        
                        case '9':
                        num = 9;
                        break;
                        
                        default:
                        num = 0;
                        break;
                        
                    }//switch(time.charAt(i))
                    
                    switch(i+1){
                        
                        case 1:
                        hour = num;
                        break;
                        
                        case 2:
                        hour = hour*10 + num;
                        break;
                        
                        case 4:
                        minute = num;
                        break;
                        
                        case 5:
                        minute = minute*10 + num;
                        break;
                        
                    }//switch(i+1)
                    
                }//for(int i = 0; i < 8; i++)
                
                this.hora = LocalTime.of(hour, minute, 0);
                
            } else {
                
                this.hora = LocalTime.of(0,0,0);
                tema = "Hora inválida!";
                
            }
            
        }catch(Exception e){
            
            this.hora = LocalTime.of(0,0,0);
            tema = e.getMessage();
            
        }
                
        this.error = tema;
        
    }//outTime(String txt)
    
    public String Err(){
        return this.error;
    }
    
    public boolean Val(){
        return this.error.isBlank();
    }
    
    public LocalTime getHora(){
        return this.hora;
    }
    
    public String getHora(boolean second){
        
        final String sep = ":";
        
        String txt = "";
        
        int h = this.hora.getHour();
        int m = this.hora.getMinute();
        
        if(h < 10){
            txt += "0";
        }
        
        txt += h;
        txt += sep;
        
        if(m < 10){
            txt += "0";
        }
        
        txt += m;
        
        if(second){
            
            int s = this.hora.getMinute();
            
            txt += sep;
            
            if(s < 10){
                txt += "0";
            }
            
            txt += s;
            
        }
        
        return txt;
        
    }//Hora()
    
    public String Load(){
        
        final char sep = '-';
        
        int h = this.hora.getHour();
        int m = this.hora.getMinute();
        int s = this.hora.getSecond();
        
        String txt = "";
        
        if(h < 10){
            txt += "0";
        }
        
        txt += h;
        txt += sep;
        
        if(m < 10){
            txt += "0";
        }
        
        txt += m;
        txt += sep;
        
        if(s < 10){
            txt += "0";
        }
        
        txt += s;
        
        return txt;
        
    }
    
}
