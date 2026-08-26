# InstantBrew

[![Fabric](https://img.shields.io/badge/Fabric-26.2-brightgreen)](https://fabricmc.net/)
[![Mod Menu](https://img.shields.io/badge/Mod%20Menu-Supported-blue)](https://modrinth.com/mod/modmenu)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)

**InstantBrew** is a simple Fabric mod for Minecraft 26.2 that allows you to configure the brewing speed of potions. Adjust the brew time from instant to vanilla (or anywhere in between) via an in-game config screen.

---

## Features

- **Configurable Brew Time** – Set the brew duration from **1 tick** (instant) to **400 ticks** (vanilla, 20 seconds).
- **In‑Game Config Screen** – Powered by **Cloth Config** and integrated with **Mod Menu**.
- **Toggleable** – Enable or disable the mod without restarting the game.
- **Lightweight** – No performance impact; just overrides a single value in the brewing stand logic.

---

## Installation

1. **Download** the latest `.jar` from the [Releases](https://github.com/artm-stack/InstantBrew/releases) page.
2. **Place** the `.jar` file in your `mods` folder.
3. **Launch** Minecraft 26.2 with **Fabric Loader** (0.19.3 or later).

### Optional Dependencies
- **Mod Menu** – for the config button in the mods list.
- **Cloth Config API** – bundled with the mod, no separate download needed.

---

## Configuration

### In‑Game (Mod Menu)
1. Open the **Mods** menu from the main screen.
2. Click **InstantBrew**.
3. Click **Configure**.
4. Adjust the settings and click **Save**.

### File‑Based
The config is stored at `config/instantbrew.json`. You can edit it manually:
```json
{
  "enabled": true,
  "brewTime": 20
}