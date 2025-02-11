🐶 Dog Image App

A simple Android app that fetches and displays random dog images using the Dog CEO API. The app maintains a cache of the last 20 generated images, ensuring they persist even after closing the app.



📌 Features

✅ Fetches and displays random dog images
✅ Stores up to 20 most recent images using an LRU cache
✅ Persists images across app restarts using Jetpack DataStore
✅ Displays recent images in a LazyRow layout
✅ Simple and clean UI using Jetpack Compose




🏗️ Tech Stack

Kotlin (Primary Language)

Jetpack Compose (Modern UI Toolkit)

Retrofit (Networking - Fetching Images)

OkHttp (HTTP Client)

Coil (Image Loading)

Jetpack ViewModel (State Management)

Jetpack DataStore (Persistent Storage)

GSON (JSON Parsing)




📸 Screenshots

🚀 Coming Soon!
![image](https://github.com/user-attachments/assets/125790e3-724a-400f-a148-9c514800470b)
![image](https://github.com/user-attachments/assets/e3767332-6a6c-4522-b3a6-c9ee6de2d25a)
![image](https://github.com/user-attachments/assets/c7486d92-5f74-4a68-96b9-9efe59c0fa0a)
![image](https://github.com/user-attachments/assets/d264b614-dd53-45f1-91c2-78f26fdcae43)








🚀 Installation & Setup

1️⃣ Clone the repository:

 git clone https://github.com/your-username/dog-image-app.git

2️⃣ Open the project in Android Studio

3️⃣ Sync Gradle and build the project

4️⃣ Run the app on an emulator or a physical device





🔧 How It Works

1. Clicking "Generate!" fetches a new dog image and adds it to the top of the cache.

2. The app removes the oldest image when there are more than 20.

3. The "My Recently Generated Dogs" screen displays all cached images.

4. The "Clear Dogs" button removes all cached images.


🏆 Contributors

👤 Ayushya Chongder - https://github.com/AyushyaChongder

