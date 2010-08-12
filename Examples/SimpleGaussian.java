/**
 * Simple test of SimpleITK's java wrapping
 */

import org.itk.simple.*;

class SimpleGaussian {
  
  public static void main(String argv[]) {
    
    // Load the library from the build directory
    LoadSimpleITK.load();
    
    // do some simple operations
    System.out.println("SimpleITK says 'Hello World' from Java");
    
    ImageFileReader reader = new ImageFileReader();
    reader.setFilename(argv[0]);
    SmartPointerImage img = reader.execute();
    
    Gaussian filt = new Gaussian();
    SmartPointerImage blurredImg = filt.execute(img);
    
    ImageFileWriter writer = new ImageFileWriter();
    writer.setFilename(argv[1]);
    writer.execute(blurredImg);
    
  }
  
}
