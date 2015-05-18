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
  String url = ""http://www.w3schools.com/images/w3schools_green.jpg";
                          or
  String[] url = {
      "http://www.w3schools.com/images/w3schools_green.jpg",
      "http://www.w3schools.com/images/w3schools_green.jpg"
  }
    
  <b>2) Pass the String url or Array of String url to getBitMapFromUrl function as</b>
  Bitmap[] bitmaps = ImageDownloader.getBitMapFromUrl(url); // returns bitmpas equal to the number of url
     
  <b>4) Pass the above "bitmaps" to setOutputMediaFile(Context c, Bitmap[] b, String path, String name);</b>
  ImageDownloader.setOutputMediaFile(context, bitmaps, "hello/sabin/doctor", "image");
    
  <b>Output</b>
  File will be downloaded and stored in 
  Android/data/"Your App Packagename"/hello/sabin/doctor/image0.png
  Android/data/"Your App Packagename"/hello/sabin/doctor/image1.png
  Android/data/"Your App Packagename"/hello/sabin/doctor/image2.png
  <b>and so on as per the number of url supplied....</b>
    
 <b> NOTE -- Perform the operation in a background thread! </b>
</pre>

