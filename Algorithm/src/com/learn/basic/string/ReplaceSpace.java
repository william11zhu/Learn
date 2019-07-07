package com.learn.basic.string;

public class ReplaceSpace {
	public String replace(char[] cString){
		if(cString == null || cString.length ==0){
			return null;
		}
		int blankCount = 0;
		int originalLength = 0;
		for(int i=0;i<cString.length;i++){
			originalLength++;
			if(cString[i]==' '){
				blankCount++;
			}
		}
		int indexOfOriginal = originalLength;
		int indexOfNew = originalLength + blankCount * 2;
		if(indexOfNew > cString.length){
			return null;
		}
		while(indexOfOriginal >= 0 && indexOfNew > indexOfOriginal){
			if(cString[indexOfOriginal] == ' '){
				cString[indexOfNew--] = '0';
				cString[indexOfNew--] = '2';
				cString[indexOfNew--] = '%';
			}else{
				cString[indexOfNew--] = cString[indexOfOriginal];
			}
			indexOfOriginal--;
		}
		return cString.toString();
	}
}
