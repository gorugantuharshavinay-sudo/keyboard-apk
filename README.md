# Telugu Keyboard APK

A simple Telugu Android IME. The editable mapping is in **`app/src/main/res/xml/telugu_keys.xml`**.

## Edit a mapping
Change both values in a key:

```xml
<Key android:codes="3093" android:keyLabel="క" />
```

- `android:keyLabel` is what appears on the key.
- `android:codes` is the Unicode code point committed to the text field. For example, `క` is U+0C15 = `3093`.
- Space is `32`, delete is `-5`, and enter is `-4`.

You can find a Telugu character's code point in Android Studio, VS Code, or with:

```python
print(ord('క'))
```

The keyboard currently uses independent Telugu letters and vowel signs. For a full phonetic/InScript keyboard, replace the rows in `telugu_keys.xml` with your preferred mapping.

## Build

Open the project in Android Studio and run **Build > Build APK(s)**, or use:

```bash
./gradlew assembleDebug
```

Enable it under **Settings > System > Keyboard > On-screen keyboard**, then select Telugu Keyboard.
