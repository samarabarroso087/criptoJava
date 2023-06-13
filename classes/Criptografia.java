package classes;

import java.io.*;

public class Criptografia {
	
	public static boolean encrypt(String origem){
		
		if(!new File(origem).exists()){
			return false;
		}
		
		String fileTemp = origem + ".tmp";
		
		try{
			
			File fileOrigem = new File(origem);
			File fileDestino = new File(fileTemp);
			
			FileInputStream entrada = new FileInputStream(fileOrigem);
			FileOutputStream saida = new FileOutputStream(fileDestino);
			
			BufferedInputStream in = new BufferedInputStream(entrada);
			BufferedOutputStream out = new BufferedOutputStream(saida);
			
			int x;
			while((x = in.read()) != -1){
				out.write(x + 5);
			}
			
			in.close();
			out.close();
			
			fileOrigem.delete();
			new File(fileTemp).renameTo(new File(origem));
			
		}catch(Exception ex){	
			return false;
		}
		
		return true;
	}
	
	public static boolean decrypt(String origem){
		
		if(!new File(origem).exists()){
			return false;
		}
		
		String fileTemp = origem + ".tmp";
		
		try{
			
			File fileOrigem = new File(origem);
			File fileDestino = new File(fileTemp);
			
			FileInputStream entrada = new FileInputStream(fileOrigem);
			FileOutputStream saida = new FileOutputStream(fileDestino);
			
			BufferedInputStream in = new BufferedInputStream(entrada);
			BufferedOutputStream out = new BufferedOutputStream(saida);
			
			int x;
			while((x = in.read()) != -1){
				out.write(x - 5);
			}
			
			in.close();
			out.close();
			
			fileOrigem.delete();
			new File(fileTemp).renameTo(new File(origem));
			
		}catch(Exception ex){
			return false;
		}
		
		return true;
	}
	
	
}