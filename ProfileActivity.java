package com.gamepoint.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.gamepoint.R;

/**
 * Created by Shiva_Subedi
 * computing project android Devlopment
 */
public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_profile);


//        TextView mTitleTv, mDetailTv;
//        ImageView mImageIv;
//
//        Bitmap bitmap;
//
//        Button mSaveBtn, mShareBtn, mWallBtn;
//
//        private static final int WRITE_EXTERNAL_STORAGE_CODE = 1;
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_post_detail);
//
//            //Action bar
//            ActionBar actionBar = getSupportActionBar();
//            //Actionbar title
//            actionBar.setTitle("Game Detail");
//            //set back button in action bar
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setDisplayShowHomeEnabled(true);
//
//            //initialize views
//            mTitleTv = findViewById(R.id.titleTv);
//            mDetailTv = findViewById(R.id.descriptionTv);
//            mImageIv = findViewById(R.id.imageView);
//            mSaveBtn = findViewById(R.id.saveBtn);
//            mShareBtn = findViewById(R.id.shareBtn);
//            mWallBtn = findViewById(R.id.wallBtn);
//
//            //get data from intent
//            byte[] bytes = getIntent().getByteArrayExtra("image");
//            String title = getIntent().getStringExtra("name");
//            String desc = getIntent().getStringExtra("description");
//            Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//
//            //set data to views
//            mTitleTv.setText(title);
//            mDetailTv.setText(desc);
//            mImageIv.setImageBitmap(bmp);
//
//            //get image from imageview as bitmap
//            bitmap = ((BitmapDrawable)mImageIv.getDrawable()).getBitmap();
//
//            //save btn click handle
//            mSaveBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    //if os is >= marshmallow we need runtime permission to save image
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
//                        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
//                                PackageManager.PERMISSION_DENIED){
//                            String[] permission = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
//                            //show popup to grant permission
//                            requestPermissions(permission, WRITE_EXTERNAL_STORAGE_CODE);
//                        }
//                        else {
//                            //permission already granted, save image
//                            saveImage();
//                        }
//                    }
//                    else {
//                        //System os is < marshmallow, save image
//                        saveImage();
//                    }
//                }
//            });
//            //share btn click handle
//            mShareBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    shareImage();
//                }
//            });
//            //set wallpaper btn click handle
//            mWallBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    setImgWallpaper();
//                }
//            });
//
//        }
//
//        private void setImgWallpaper() {
//            //CALL METHOD
//            //WallpaperManager myWallManager = WallpaperManager.getInstance(getApplicationContext());
//            try {
//                //myWallManager.setBitmap(bitmap);
//                startActivity(new Intent(getApplicationContext(), Admin.class));
//                Toast.makeText(this, "ONLINE GAME OPENING ...", Toast.LENGTH_SHORT).show();
//            }
//            catch (Exception e){
//                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }
//
//        private void shareImage() {
//            try {
//                startActivity(new Intent(getApplicationContext(), RewardGame.class));
//            }
//            catch (Exception e){
//                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }
//
//        private void saveImage() {
//            //time stamp, for image name give unique image id for each download
//            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
//                    Locale.getDefault()).format(System.currentTimeMillis());
//            //path to external storage
//            File path = Environment.getExternalStorageDirectory();
//            //create folder named "Firebase"
//            File dir = new File(path+"/Firebase/");
//            dir.mkdirs();
//            //image name
//            String imageName = timeStamp + ".PNG";
//            File file = new File(dir, imageName);
//            OutputStream out;
//            try {
//                out = new FileOutputStream(file);
//                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
//                out.flush();
//                out.close();
//                Toast.makeText(this, imageName+" saved to"+ dir, Toast.LENGTH_SHORT).show();
//            }
//            catch (Exception e){
//                //failed saving image
//                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }
//
//        //handle onBackPressed(go to previous activity)
//        @Override
//        public boolean onSupportNavigateUp() {
//            onBackPressed();
//            return true;
//        }
//
//        @Override
//        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//            switch (requestCode){
//                case WRITE_EXTERNAL_STORAGE_CODE:{
//                    //if request code is cancelled the result arrays are empty
//                    if (grantResults.length > 0 && grantResults[0] ==
//                            PackageManager.PERMISSION_GRANTED){
//                        //permission is granted, save image
//                        saveImage();
//                    }
//                    else {
//                        //permission denied
//                        Toast.makeText(this, "Enable permission to save image", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//
//        }

    }
}
