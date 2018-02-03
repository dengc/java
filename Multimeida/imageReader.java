//Name: Chufan Deng

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;


public class imageReader {
	
	static int Y;
    static int U;
    static int V;
    static int Q;
    static int imgHeight = 288;
	static int imgWidth = 352;

	static int rgbImage[] = new int[3 * imgHeight * imgWidth];
    static double yuvImage[] = new double[3 * imgHeight * imgWidth];

	

	// public void showIms(String[] args){

	// 	img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

	// 	try {
	// 		File file = new File(args[0]);
	// 		InputStream is = new FileInputStream(file);

	// 		long len = file.length();
	// 		byte[] bytes = new byte[(int)len];

	// 		int offset = 0;
	// 		int numRead = 0;
	// 		while (offset < bytes.length && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	// 			offset += numRead;
	// 		}


	// 		int ind = 0;
	// 		for(int y = 0; y < height; y++){

	// 			for(int x = 0; x < width; x++){

	// 				byte a = 0;
	// 				byte r = bytes[ind];
	// 				byte g = bytes[ind+height*width];
	// 				byte b = bytes[ind+height*width*2]; 

	// 				int pix = 0xff000000 | ((r & 0xff) << 16) | ((g & 0xff) << 8) | (b & 0xff);
	// 				//int pix = ((a << 24) + (r << 16) + (g << 8) + b);
	// 				img.setRGB(x,y,pix);
	// 				ind++;
	// 			}
	// 		}


	// 	} catch (FileNotFoundException e) {
	// 		e.printStackTrace();
	// 	} catch (IOException e) {
	// 		e.printStackTrace();
	// 	}

	// 	// Use labels to display the images
	// 	frame = new JFrame();
	// 	GridBagLayout gLayout = new GridBagLayout();
	// 	frame.getContentPane().setLayout(gLayout);

	// 	JLabel lbText1 = new JLabel("Original image (Left)");
	// 	lbText1.setHorizontalAlignment(SwingConstants.CENTER);
	// 	JLabel lbText2 = new JLabel("Image after modification (Right)");
	// 	lbText2.setHorizontalAlignment(SwingConstants.CENTER);
	// 	lbIm1 = new JLabel(new ImageIcon(img));
	// 	lbIm2 = new JLabel(new ImageIcon(img));

	// 	GridBagConstraints c = new GridBagConstraints();
	// 	c.fill = GridBagConstraints.HORIZONTAL;
	// 	c.anchor = GridBagConstraints.CENTER;
	// 	c.weightx = 0.5;
	// 	c.gridx = 0;
	// 	c.gridy = 0;
	// 	frame.getContentPane().add(lbText1, c);

	// 	c.fill = GridBagConstraints.HORIZONTAL;
	// 	c.anchor = GridBagConstraints.CENTER;
	// 	c.weightx = 0.5;
	// 	c.gridx = 1;
	// 	c.gridy = 0;
	// 	frame.getContentPane().add(lbText2, c);

	// 	c.fill = GridBagConstraints.HORIZONTAL;
	// 	c.gridx = 0;
	// 	c.gridy = 1;
	// 	frame.getContentPane().add(lbIm1, c);

	// 	c.fill = GridBagConstraints.HORIZONTAL;
	// 	c.gridx = 1;
	// 	c.gridy = 1;
	// 	frame.getContentPane().add(lbIm2, c);

	// 	frame.pack();
	// 	frame.setVisible(true);
	// }

	public static void main(String[] args) {
		// imageReader ren = new imageReader();
		// ren.showIms(args);
		
		// String fileName = args[0];
		JFrame frame;
		JLabel lbIm1;
		JLabel lbIm2;
		BufferedImage img;
	   	Y = Integer.parseInt(args[1]);
	    U = Integer.parseInt(args[2]);
	    V = Integer.parseInt(args[3]);
	    Q = Integer.parseInt(args[4]);

	    img = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
	    BufferedImage imgOriginal = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);


	    try {
		    File file = new File(args[0]);
		    InputStream is = new FileInputStream(file);

		    long len = file.length();
		    byte[] bytes = new byte[(int)len];
		    
		    int offset = 0;
	        int numRead = 0;
	        while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length-offset)) >= 0) {
	            offset += numRead;
	        }
	        
	    	int ind = 0;
			for(int h = 0; h < imgHeight; h++){
				for(int x = 0; x < imgWidth; x++){
					byte a = 0;

					byte r = bytes[ind];
	                if(r < 0) {
	                    rgbImage[(h * imgWidth + x) * 3] = r + 256;
	                } else {
	                    rgbImage[(h * imgWidth + x) * 3] = r;
	                }
	                
					byte g = bytes[ind + imgHeight * imgWidth];
	                if(g < 0) {
	                    rgbImage[(h * imgWidth + x) * 3 + 1] = g + 256;
	                } else {
	                    rgbImage[(h * imgWidth + x) * 3 + 1] = g;
	                }
	                
					byte b = bytes[ind + imgHeight * imgWidth * 2];
	                if(b < 0) {
	                    rgbImage[(h * imgWidth + x) * 3 + 2] = b + 256;
	                } else {
	                    rgbImage[(h * imgWidth + x) * 3 + 2] = b;
	                }
	                
	                yuvImage[(h * imgWidth + x) * 3] = RGBtoY(rgbImage[(h * imgWidth + x) * 3], rgbImage[(h * imgWidth + x) * 3 + 1], rgbImage[(h * imgWidth + x) * 3 + 2]);
	                
	                yuvImage[(h * imgWidth + x) * 3 + 1] = RGBtoU(rgbImage[(h * imgWidth + x) * 3], rgbImage[(h * imgWidth + x) * 3 + 1], rgbImage[(h * imgWidth + x) * 3 + 2]);
	                
	                yuvImage[(h * imgWidth + x) * 3 + 2] = RGBtoV(rgbImage[(h * imgWidth + x) * 3], rgbImage[(h * imgWidth + x) * 3 + 1], rgbImage[(h * imgWidth + x) * 3 + 2]);
	                
					int pixOriginal = 0xff000000 | ((r & 0xff) << 16) | ((g & 0xff) << 8) | (b & 0xff);
	                imgOriginal.setRGB(x,h,pixOriginal);
					ind++;
				}
			}
			
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    subSample();
	    
	    for(int y = 0; y < imgHeight; y++){
	        for(int x = 0; x < imgWidth; x++){
	            int i = y * imgWidth + x;
	            
	            byte r, g, b;

	            rgbImage[3 * i] = (int)Math.rint(YUVtoR(yuvImage[3 * i], yuvImage[3 * i + 1], yuvImage[3 * i + 2]));
	            rgbImage[3 * i] = quantization(rgbImage[3 * i]);
	            if(rgbImage[3 * i] < 0) {
	                rgbImage[3 * i] = 0;
	            } else if(rgbImage[3 * i] > 255) {
	                rgbImage[3 * i] = 255;
	            }
	            
	            rgbImage[3 * i + 1] = (int)Math.rint(YUVtoG(yuvImage[3 * i], yuvImage[3 * i + 1], yuvImage[3 * i + 2]));
	            rgbImage[3 * i + 1] = quantization(rgbImage[3 * i + 1]);
	            if(rgbImage[3 * i + 1] < 0) {
	                rgbImage[3 * i + 1] = 0;
	            } else if(rgbImage[3 * i + 1] > 255) {
	                rgbImage[3 * i + 1] = 255;
	            }
	            
	            rgbImage[3 * i + 2] = (int)Math.rint(YUVtoB(yuvImage[3 * i], yuvImage[3 * i + 1], yuvImage[3 * i + 2]));
	            rgbImage[3 * i + 2] = quantization(rgbImage[3 * i + 2]);
	            if(rgbImage[3 * i + 2] < 0) {
	                rgbImage[3 * i + 2] = 0;
	            } else if(rgbImage[3 * i + 2] > 255) {
	                rgbImage[3 * i + 2] = 255;
	            }
	    
	            if(rgbImage[3 * i] > 127) {
	                r = (byte)(rgbImage[3 * i] - 256);
	            } else {
	                r = (byte)rgbImage[3 * i];
	            }
	            
	            if(rgbImage[3 * i + 1] > 127) {
	                g = (byte)(rgbImage[3 * i + 1] - 256);
	            } else {
	                g = (byte)rgbImage[3 * i + 1];
	            }
	            
	            if(rgbImage[3 * i + 2] > 127) {
	                b = (byte)(rgbImage[3 * i + 2] - 256);
	            } else {
	                b = (byte)rgbImage[3 * i + 2];
	            }
	            
	            int pix = 0xff000000 | ((r & 0xff) << 16) | ((g & 0xff) << 8) | (b & 0xff);
	            img.setRGB(x,y,pix);
	        }
	    }

	    JPanel panel = new JPanel ();
	    panel.add (new JLabel (new ImageIcon (imgOriginal)));
	    panel.add (new JLabel (new ImageIcon (img)));
	    
	    frame = new JFrame("images");
	    
	    frame.getContentPane().add (panel);
	    frame.pack();
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	}

	//subsampling
	public static void subSample() {
        for(int h = 0; h < imgHeight; h++){
        	int index = 0;
        	int index1 = 0;
        	int index2 = 0;
            if(Y > 1) {
                int x;
                for(x = 0; x < imgWidth - Y; x+=Y){
                    for(int z = x + 1; z < x + Y; z++) {
                    	index = (imgWidth * h + z) * 3;
                    	index1 = (imgWidth * h + x) * 3;
                    	index2 = (imgWidth * h + x + Y) * 3;
                        yuvImage[index] = (yuvImage[index1] + yuvImage[index2]) / 2;
                    }
                }
                x++;
                for(; x < imgWidth; x++) {
                    index = (imgWidth * h + x) * 3;
                    index1 = (imgWidth * h + imgWidth - Y) * 3;
                    yuvImage[index] = yuvImage[index1];
                }
            }

            if(U > 1) {
                int x;
                for(x = 0; x < imgWidth - U; x+=U){
                    for(int z = x + 1; z < x + U; z++) {
                    	index = (imgWidth * h + z) * 3 + 1;
                    	index1 = (imgWidth * h + x) * 3 + 1;
                    	index2 = (imgWidth * h + x + U) * 3 + 1;
                        yuvImage[index] = (yuvImage[index1] + yuvImage[index2]) / 2;
                    }
                }
                x++;
                for(; x < imgWidth; x++) {
                	index = (imgWidth * h + x) * 3 + 1;
                    index1 = (imgWidth * h + imgWidth - U) * 3 + 1;
                    yuvImage[index] = yuvImage[index1];
                }
            }
            
            if(V > 1) {
                int x;
                for(x = 0; x < imgWidth - V; x+=V){
                    for(int z = x + 1; z < x + V; z++) {
                    	index = (imgWidth * h + z) * 3 + 2;
                    	index1 = (imgWidth * h + x) * 3 + 2;
                    	index2 = (imgWidth * h + x + V) * 3 + 2;
                    	yuvImage[index] = (yuvImage[index1] + yuvImage[index2]) / 2;
                    }
                }
                x++;
                for(; x < imgWidth; x++) {
                	index = (imgWidth * h + x) * 3 + 2;
                    index1 = (imgWidth * h + imgWidth - V) * 3 + 2;
                    yuvImage[index] = yuvImage[index1];
                }
            }
        }
    }

	//RGB to YUV
   	public static double RGBtoY(int r, int g, int b) {
       	return (0.299 * r + 0.587 * g + 0.114 * b);
   	}
    public static double RGBtoU(int r, int g, int b) {
        return (0.596 * r - 0.274 * g - 0.322 * b);
    }
    public static double RGBtoV(int r, int g, int b) {
        return (0.211 * r - 0.523 * g + 0.312 * b);
    }
    
    //YUV to RGB
    public static double YUVtoR(double y, double u, double v){
        return (y + 0.956 * u + 0.621 * v);
    }
    public static double YUVtoG(double y, double u, double v) {
        return (y - 0.272 * u - 0.647 * v);
    }
    public static double YUVtoB(double y, double u, double v) {
        return (y - 1.106 * u + 1.703 * v);
    }

    // quantization
	public static int quantization(int input) {
		if(Q > 0 && Q < 256) {
	        int span = 256 / Q;
	        int res = 255 - span;
	        if(input > res) {
	            return res;
	        }
	        int level = (int) Math.rint((input + 1) / span);
	        return span * level - 1;
	    }
	    return input;
    }
}