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


<b>1) Add url in a string or array of string</b>
<pre>String url = "http://www.w3schools.com/images/w3schools_green.jpg";
                        or
String[] url = {
    "http://www.w3schools.com/images/w3schools_green.jpg",
    "http://www.w3schools.com/images/w3schools_green.jpg"
}
</pre>
  
<b>2) Pass the String url or Array of String url to getBitMapFromUrl(String... url)</b>
<pre>Bitmap[] bitmaps = ImageDownloader.getBitMapFromUrl(url); // returns bitmpas equal to the number of url</pre>
   
<b>3) Call setOutputMediaFile(Context c, Bitmap[] bitmpas, String path, String nameOfPic); and provide appropriate parameters</b>
<pre>
if(bitmaps != null){
  ImageDownloader.setOutputMediaFile(context, bitmaps, "hello/sabin/doctor", "mypic"); //stores the images in internal storage
}
</pre>  
<b>Output</b>
<pre>File will be downloaded and stored in Internal Storage of the app.
The name of the image will be as  
--- nameOfPic0.jpg  // here in the example nameOfPic = mypic so (mypic0.jpg)
--- nameOfPic1.jpg
--- nameOfPic2.jpg and so on as per the number of url supplied
</pre>
<b>4) Use the downloaded images</b>
<pre>File file = new File(getFilesDir(),"hello/sabin/doctor/" + "mypic1.jpg"); //To use image from second url
if(file.exists()){
  //use the file as necessary
}
</pre>  

<h4> NOTE -- Perform the operation in a background thread! </h4>


