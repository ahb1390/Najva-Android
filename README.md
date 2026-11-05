<div align="center">

<img src="docs/icon.svg" width="96" height="96" alt="Najva" />

# Najva

An offline maddahi and devotional recitation player for Android.<br>
No account, no subscription, no ads. Your library stays on your phone.

<a href="https://github.com/ahb1390/Najva-Android/releases/latest"><img alt="Download APK" src="https://img.shields.io/badge/Download-APK-2ea44f?logo=android&logoColor=white" /></a>
<a href="https://github.com/ahb1390/Najva-Android/releases"><img alt="Downloads" src="https://img.shields.io/github/downloads/ahb1390/Najva-Android/total?label=downloads&color=2ea44f" /></a>
<img alt="Android 8.0+" src="https://img.shields.io/badge/Android-8.0%2B-3DDC84?logo=android&logoColor=white" />
<img alt="License: Apache 2.0" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg" />

English · [فارسی](README.fa.md)

</div>

<p align="center">
  <img src="docs/screenshots/home.png" width="23%" alt="Home" />
  <img src="docs/screenshots/player.png" width="23%" alt="Player" />
  <img src="docs/screenshots/lyrics.png" width="23%" alt="Lyrics" />
  <img src="docs/screenshots/library.png" width="23%" alt="Library" />
</p>

## About

Najva plays the maddahi and devotional recitations already stored on your phone. Playlists, history, edited audio tags and recitation text are stored on the device, and your files never leave it. The features that use the network are the ones you start yourself — online recitation text, audio downloads and the optional AI playlist — plus a daily check for a newer release on GitHub and, optionally, one anonymous install record on first launch when the maintainer configures an install-counter endpoint. App updates never send that record again. Neither call includes an account, file names, library data or an advertising id. GitHub also counts APK downloads the same way it counts any other file.

## Features

### Playback
- Cross-fade between recitations, skip silence, per-recitation playback speed
- Sleep timer by minutes or by number of recitations; resume position for long tracks
- Playback resumes when headphones reconnect
- Swipe the cover to preview the next or previous recitation; the next cover always waits on the right, so swiping left advances and swiping right goes back
- ReplayGain (recitation and collection), preamp, 5-band equalizer, bass boost and virtualizer
- Home screen widgets in five sizes, from a 2×2 cover to a 4×4 player with an up-next queue

### Queue
- Three sections: what already played, what is playing now, and what comes next
- Drag the grip to reorder upcoming recitations; the played section stays put as history
- Swipe a row to remove it, with undo; tap any row to jump to it
- Save the whole queue as a playlist in one tap

### Recitation text
- Reads recitation text embedded in the audio file or from a `.lrc` file beside it, or fetches them online (LRCLIB, NetEase, Kugou, lyrics.ovh, Genius)
- Synced scrolling, timing adjustment, manual editing, import and export
- Each online source can be turned off, and you can point the app at your own recitation-text server

### Tags and covers
- Edit recitation title, maddah name, collection, category, year and audio-file information
- Change, crop or remove the cover art; find covers online from iTunes and Deezer
- Auto-fill tags from online metadata; a "Fix names" tool cleans messy file names
- Writes go to a staged copy and are verified before the original file is replaced

### Maddahi library
- Sort and filter by recitation title, maddah, collection and year, date added, duration, play count and more
- Multi-select for queueing, playlists, favorites and hiding recitations
- Swipe a recitation to the right to play it next without interrupting playback
- Hides ringtones, notifications, alarms and recordings by default, with a switch to show them
- Stats for your most played recitations, maddah and collections

### Maddahi downloads
- Search and download from YouTube, SoundCloud and MusicMan, in original quality
- Collection downloads with a recitation picker, duplicate detection and one summary notification
- Metadata and cover art merged from Deezer, iTunes and MusicBrainz; the selected source's maddah metadata takes priority

### AI (optional)
- Describe a mood and get a recitation playlist; regenerate the daily mix while keeping the current recitations
- Works with Gemini or any OpenAI-compatible endpoint you configure; the key stays on the device

### Updates and installs
- The app checks GitHub for a newer release about once a day and offers to download and install it
- The APK is matched to your CPU (arm64-v8a, armeabi-v7a, x86), downloaded with progress, and handed to the Android installer
- Settings → About shows the installed version, the latest release and its download count

### Appearance and data
- Material 3 with a custom palette; colors can follow the collection artwork, the wallpaper or your own choice
- Full Persian localization and right-to-left layout
- Backup and restore playlists, favorites, history and recitation text in one file; M3U import and export

## Install

- Android 8.0 or newer. The release page has one APK per CPU; most phones want `arm64-v8a`.
- Get the APK from [GitHub Releases](https://github.com/ahb1390/Najva-Android/releases/latest).
- After the first install, the app updates itself: it finds the newer release, downloads the matching APK and opens the installer. Android verifies the signature, so updates can only come from the same developer.

## Build from source

```bash
git clone https://github.com/ahb1390/Najva-Android.git
cd Najva-Android
./gradlew :app:assembleDebug
```

- JDK 17+ and the Android SDK (compileSdk 36) are required.
- Version numbers come from the git tag; fetch tags before building a release.
- Networks where Google Maven is blocked can opt into mirrors by adding `najva.mirrors=true` to `local.properties`.
- Release signing reads `KEYSTORE_PATH`, `KEYSTORE_PASSWORD`, `KEY_ALIAS` and `KEY_PASSWORD` from the environment or Gradle properties.

## Privacy

- Your recitations, playlists, history, audio tags and recitation text never leave the device.
- Online recitation text, downloads and the AI playlist only run when you start them.
- The daily update check sends a plain HTTPS request to GitHub with no device information.
- An anonymous install counter is optional and only runs when the maintainer configures `INSTALL_ENDPOINT`; otherwise no install record is sent.
- No advertising id, no analytics SDK, no crash reporter.

## Third-party

The download feature uses [youtubedl-android](https://github.com/junkfood02/youtubedl-android) and [yt-dlp](https://github.com/yt-dlp/yt-dlp) (GPL-3.0); released APKs bundle them. See [THIRD_PARTY_NOTICES](THIRD_PARTY_NOTICES).
The bundled [Vazirmatn](https://github.com/rastikerdar/vazirmatn) font is licensed under SIL OFL 1.1, see [OFL.txt](app/src/main/assets/OFL.txt).

## License

Apache License 2.0 — see [LICENSE](LICENSE).

Najva is a community fork of [LogaRhythm](https://github.com/Yasinjahantigh/LogaRhythm-Android). Bugs, ideas and pull requests are welcome through the Issues tab.
