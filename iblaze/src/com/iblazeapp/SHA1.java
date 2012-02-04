/*
 * A Java implementation of the Secure Hash Algorithm, SHA-1, as defined
 * in FIPS PUB 180-1
 * Copyright (C) Sam Ruby 2004
 * All rights reserved
 *
 * Based on code Copyright (C) Paul Johnston 2000 - 2002.
 * See http://pajhome.org.uk/site/legal.html for details.
 *
 * Converted to Java by Russell Beattie 2004
 * Base64 logic and inlining by Sam Ruby 2004
 * Bug fix correcting single bit error in base64 code by John Wilson
 *
 *                                BSD License
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer. Redistributions in binary
 * form must reproduce the above copyright notice, this list of conditions and
 * the following disclaimer in the documentation and/or other materials
 * provided with the distribution.
 *
 * Neither the name of the author nor the names of its contributors may be
 * used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package com.iblazeapp;






public class SHA1 {

    /*
     * Bitwise rotate a 32-bit number to the left
     */
    private static int rol(int num, int cnt) {
        return (num << cnt) | (num >>> (32 - cnt));
    }

    /*
     * Take a string and return the base64 representation of its SHA-1.
     */


public static String  hex(int num)
{
    
    
     String  hex_chr = new String("0123456789abcdef");
     String str = new String("");
     for(int  j = 7; j >= 0; j--)
  
     {
  
        str += hex_chr.charAt((num >> (j * 4)) & 0x0F);
      }
  
  
  return str;
}
public static int[]  str2blks_SHA1(String str)
{
  int nblk = ((str.length() + 8) >> 6) + 1;
  int [] blks = new int[nblk * 16];
  
  int i;
  for( i = 0; i < nblk * 16; i++) blks[i] = 0;
  
  for( i = 0; i < str.length(); i++)
    blks[i >> 2] |= str.charAt(i) << (24 - (i % 4) * 8);
  blks[i >> 2] |= 0x80 << (24 - (i % 4) * 8);
  blks[nblk * 16 - 1] = str.length() * 8;
  return blks;
}
/*
 * Perform the appropriate triplet combination function for the current
 * iteration
 */
public static int   ft(int t,int b, int c, int d)
{
  if(t < 20) return (b & c) | ((~b) & d);
  if(t < 40) return b ^ c ^ d;
  if(t < 60) return (b & c) | (b & d) | (c & d);
  return b ^ c ^ d;
}
/*
 * Determine the appropriate additive constant for the current iteration
 */


public static int  kt(int t)
{
  return (t < 20) ?  1518500249 : (t < 40) ?  1859775393 :
         (t < 60) ? -1894007588 : -899497514;
}



public static int safe_add(int x,int y)
{
  int lsw = (x & 0xFFFF) + (y & 0xFFFF);
  int msw = (x >> 16) + (y >> 16) + (lsw >> 16);
  return (msw << 16) | (lsw & 0xFFFF);
}
     
     
     
     
public static String calcSHA1(String str)
{
  int  []x = str2blks_SHA1(str);
  int []w = new int[80];

  int a =  1732584193;
  int b = -271733879;
  int c = -1732584194;
  int d =  271733878;
  int e = -1009589776;


  for(int i = 0; i < x.length; i += 16)
  {
    int olda = a;
    int oldb = b;
    int oldc = c;
    int oldd = d;
    int olde = e;

    for(int j = 0; j < 80; j++)
    {
      if(j < 16) w[j] = x[i + j];
      else w[j] = rol(w[j-3] ^ w[j-8] ^ w[j-14] ^ w[j-16], 1);
      int t = safe_add(safe_add(rol(a, 5), ft(j, b, c, d)), safe_add(safe_add(e, w[j]), kt(j)));
      e = d;
      d = c;
      c = rol(b, 30);
      b = a;
      a = t;
    }

    a = safe_add(a, olda);
    b = safe_add(b, oldb);
    c = safe_add(c, oldc);
    d = safe_add(d, oldd);
    e = safe_add(e, olde);
  }
  return hex(a) + hex(b) + hex(c) + hex(d) + hex(e);
}




   
}
