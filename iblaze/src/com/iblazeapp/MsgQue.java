/*
 * MsgQue.java
 *
 * © <your company here>, <year>
 * Confidential and proprietary.
 */

package com.iblazeapp;





/**
 * 
 */
class MsgQue {
    
    
    byte              []m_pData;
    int                m_dwSize;

     
    MsgQue() 
    { 
           
            m_dwSize = 0;
    }
    

  
    
    
    
byte[] bGet_data()
{
    
    
    return m_pData;
    
  

     
}

int   bGet_size()
{
    
    
    return m_dwSize;
    
 
}


boolean  bPut( byte [] pData, int  dwSize)
{
    
    
        m_pData=null;
        
         m_pData=new byte[dwSize];
      
      
         for (int i=0; i<dwSize; i++){
         
               m_pData[i]=0;    
         }
         
         
          for (int i=0; i<dwSize; i++){
         
               m_pData[i]=pData[i];    
         }
         
         
         
         
          m_dwSize = dwSize;
        
       
         
         return true;
   
   
}


} 










