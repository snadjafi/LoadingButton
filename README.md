# LoadingButton [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-LoadingButton-green.svg?style=flat)](https://android-arsenal.com/details/1/1926)

LoadingButton is a custom view that shows and hides a ProgressBar with text animation. You can specify the text animation direction.

![LoadingButton](https://github.com/snadjafi/LoadingButton/blob/master/images/screenshot.png)

## Sample Usage

```xml
<com.snad.loadingbutton.LoadingButton
    android:id="@+id/first"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="#BE6E46"
    app:pbLoadingText="@string/loading"
    app:pbProgressColor="#F9D8FB"
    app:pbText="@string/click_me"
    app:pbTextColor="#8A4FFF"
    app:pbTextSize="16sp"/>
```

```java
@Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    findViewById(R.id.first).setOnClickListener(this);

    LoadingButton button = new LoadingButton(this);
    LoadingButton.ViewSwitcherFactory factory = new LoadingButton.ViewSwitcherFactory(this,
            getResources().getColor(android.R.color.white),
            44F,
            Typeface.DEFAULT);
    button.setTextFactory(factory);

    button.setText("Press");
    button.setLoadingText("wait...");
    button.setBackgroundColor(Color.RED);
    button.setOnClickListener(this);
    button.setAnimationInDirection(LoadingButton.IN_FROM_LEFT);
    ((ViewGroup) findViewById(R.id.root)).addView(button);
}

@Override public void onClick(final View v) {
    ((LoadingButton) v).showLoading();

    v.postDelayed(new Runnable() {
        @Override public void run() {
            ((LoadingButton) v).showButtonText();
        }
    }, 2000);
}
```

##License

    Copyright 2015 Shervin Najafi
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
