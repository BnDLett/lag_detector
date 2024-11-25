# Lag Detector Plugin
A plugin that detects whenever a server's TPS is too low. Whenever the server TPS goes below a threshold, 
the plugin will kill all units and destroy all payload sources.

# How To Install
## Release Jar (recommended | most stable)
1. Download the latest jar from the release page.
2. Copy (or cut -- whatever floats your boat) the jar file into `server_root/config/mods/` -- with 
   `server_root` being the root directory of your server.
3. Run the server
4. Configure the plugin to your pleasure (note that `minimumTPS` is the ONLY configuration available).

## Source (not recommended | least stable)
oh boy...
1. Ensure that you have installed JDK 17
2. Clone the repository onto your local machine via git
3. Open your terminal (or command prompt if you're on Windows)
4. `cd` into the directory of the cloned repository
5. Run `./gradlew jar` or `gradlew.bat jar` if you're on Windows
6. Copy (or cut -- whatever floats your boat) `project_root/build/libs/lag_detector.jar` (with `project_root`
   being the root directory of the cloned repository) into `server_root/config/mods/` (with `server_root` 
   being the root directory of your server).
7. Run the server
8. Configure the plugin to your pleasure (note that `minimumTPS` is the ONLY configuration available).

# Compatible Versions
The major versions of Mindustry that this plugin is compatible with. Note that versions with a
strike-through is deprecated and/or not planned.
- [ ] ~~<= V6~~
- [x] V7
- [ ] V8
