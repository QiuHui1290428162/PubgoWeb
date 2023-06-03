package com.pubgo.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.pubgo.exception.ImoocMallException;
import com.pubgo.exception.ImoocMallExceptionEnum;

import net.coobird.thumbnailator.Thumbnails;

//文件操作工具类
public class FileUtil {

	//存储文件，并返回路径
	//多个文件
	public static List<String> saveFile(List<CommonsMultipartFile> files){
		
		List<String> imagePaths = new ArrayList<String>();
	    //遍历文件
	    for (CommonsMultipartFile file : files) {
	        // 检查文件是否为空
	        if (!file.isEmpty()) {
	        	//设置存放路径.file.getOriginalFilename()返回图片名称+后缀名
	        	imagePaths.add(Constant.NURSINGSTATICPATHS
	    	    		+new Date().getTime()+file.getOriginalFilename());
	    	    //通过CommonsMultipartFile 的方法直接写文件
	    	    //file.transferTo(new File(path));
	        	//压缩图片大小
			    try {
					Thumbnails.of(file.getInputStream())
					.scale(0.5f)
					.toFile(imagePaths.get(imagePaths.size()-1));
				} catch (IOException e) {
					e.printStackTrace();
					throw new ImoocMallException(ImoocMallExceptionEnum.NOT_IMAGE_COMPRESSION);
				}
	        }
	    }
		return imagePaths;
	}
	
	//多个文件
	public static String saveFile(CommonsMultipartFile file){
		String imagePath = "";
        if (!file.isEmpty()) {
        	//设置存放路径.file.getOriginalFilename()返回图片名称+后缀名
        	imagePath = Constant.NURSINGSTATICPATHS
    	    		+new Date().getTime()+file.getOriginalFilename();
        	//通过CommonsMultipartFile 的方法直接写文件
    	    //file.transferTo(new File(path));
        	//压缩图片大小
		    try {
				Thumbnails.of(file.getInputStream())
				.scale(0.5f)
				.toFile(imagePath);
			} catch (IOException e) {
				e.printStackTrace();
				throw new ImoocMallException(ImoocMallExceptionEnum.NOT_IMAGE_COMPRESSION);
			}
        }
		
		return imagePath;
	}
}
