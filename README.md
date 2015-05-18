# Url-To-Image-File
An android library to fetch image from url and store them in the device storage

Steps to add the libray in Android Studio </br>
<ul>
  <li>Download the above library</li>
  <li>Go to File &gt; New &gt; Import Module</li>
  <li>Locate the downloaded library location in <b>"Source directory"</b> and give a module name as <b>:urltoimage </b> or any other name and click Finish</li>
  <li>add &nbsp;&nbsp;&nbsp; <b>include ':app', ':urltoimage'</b> &nbsp;&nbsp;&nbsp; in settings.gradle</b></li>
  <li>add &nbsp;&nbsp;&nbsp; <b>compile project(':urltoimage')</b> &nbsp;&nbsp;&nbsp;in your app build.gradle</li>
  <li>Lastly sync your gradle</li>
</ul>

<h2>Using the Libray</h2>

<pre>
  <b>1) Add url in a string or array of string</b>
  String url = "http://www.w3schools.com/images/w3schools_green.jpg";
                          or
  String[] url = {
      "http://www.w3schools.com/images/w3schools_green.jpg",
      "http://www.w3schools.com/images/w3schools_green.jpg"
  }
    
  <b>2) Pass the String url or Array of String url to getBitMapFromUrl function as</b>
  Bitmap[] bitmaps = ImageDownloader.getBitMapFromUrl(url); // returns bitmpas equal to the number of url
     
  <b>4) Pass the above "bitmaps" to setOutputMediaFile(Context c, Bitmap[] b, String path, String nameOfPic);</b>
  if(bitmaps != null){
    ImageDownloader.setOutputMediaFile(context, bitmaps, "hello/sabin/doctor", "mypic");
  }
    
  <b>Output</b>
  File will be downloaded and stored in Internal Storage of the app.
  The name of the image will be as  
  --- nameOfPic0.jpg  // here in the example nameOfPic = mypic so (mypic0.jpg)
  --- nameOfPic1.jpg
  --- nameOfPic2.jpg and so on as per the number of url supplied
  
  <b>4) Use the downloaded images</b>
  File file = new File(getFilesDir(),"hello/sabin/doctor/" + "mypic1.jpg"); //To use image from second url
  if(file.exists()){
    //use the file as necessary
  }
    
 <b> NOTE -- Perform the operation in a background thread! </b>
</pre>

