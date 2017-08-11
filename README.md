Generic Adapter
===================================

Library that encapsulates common Adapter and RecyclerView methods.

Pre-requisites
--------------

- Android SDK 25
- Android Build Tools v25.0.2
- Android Support Repository

Installation
------------

Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
  repositories {
	  ...
	  maven { url 'https://jitpack.io' }
  }
}

```

Add the dependency

```groovy
dependencies {
  compile 'com.github.xramos:GenericAdapter:1.0.0'
}
```

How To Use
----------

Create a ViewHolder that inherits from GenericViewHolder

```groovy
public class StringViewHolder extends GenericViewHolder<String> {
	
  public TextView txtView;

  public StringViewHolder(View itemView) {
	  super(itemView);
	  txtView = (TextView)itemView.findViewById(R.id.txtView);
  }

  @Override
  public void bind(String model) {
	  txtView.setText(model);
  }
}
```

Create an Adapter that inherits from GenericAdapter

```groovy
public class StringAdapter extends GenericAdapter<String, StringViewHolder> {
	
  public StringAdapter(Context ctx, int layoutId, List<String> objects) {
    super(ctx, layoutId, objects);
  }

  @Override
  @Override
  public StringViewHolder createViewHolder(View itemView) {
	  return new StringViewHolder(itemView);
  }
}
```

Create a RecyclerAdapter that inherits from GenericRecyclerView

```groovy
public class StringAdapter extends GenericRecyclerAdapter<String, StringViewHolder> {
	
  public StirngAdapter(Context ctx, int layoutId, List<String> objects) {
   	  super(ctx, layoutId, objects);
  }

  @Override
  public StringViewHolder createViewHolder(View itemView) {
	  return new StringViewHolder(itemView);
  }
}
```

You can implement OnRecyclerViewItemClickListener on your Activity like this:

```groovy
public class StringActivity extends AppCompatActivity implements OnRecyclerViewItemClickListener<String> {
	
  ...

  @Override
  public void onItemClick(View view, String model) {
	  //Implement OnRecyclerViewItmeClick
  }
}
```

You can implement OnRecyclerViewScrollListener on your Activity like this:

```groovy
public class StringActivity extends AppCompatActivity implements OnRecyclerViewItemClickListener<String> {
	
  ...

  RecyclerView rView;
  LinearLayoutManager rManager;

  ...

  rView.addOnScrollListener(new OnRecyclerViewScrollListener(rManager) {
	  @Override
	  public void onLoadMore(int page, int totalItemsCount) {
		  // Triggered only when new data needs to be appended to the list
		  //Add whatever code is needed to append new items to the bottom of the list
	  }
  });
}
```

You can implement OnListViewScrollListener on your Activity like this:

```groovy
public class StringActivity extends AppCompatActivity {
	
  ...

  ListView listView;

  ...

  listView.setOnScrollListener(new OnListViewScrollListener() {
    @Override
    public void onLoadMore(int page, int totalItemsCount) {
      // Triggered only when new data needs to be appended to the list
      //Add whatever code is needed to append new items to the bottom of the list
    }
  });
}
```

License
-------

Copyright 2017 Xavi Ramos

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.
