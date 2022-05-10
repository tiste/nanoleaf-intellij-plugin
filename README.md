# nanoleaf-intellij-plugin

[![Build](https://github.com/tiste/nanoleaf-intellij-plugin/actions/workflows/build.yml/badge.svg)](https://github.com/tiste/nanoleaf-intellij-plugin/actions/workflows/build.yml)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)

<!-- Plugin description -->
Want fancy coloured and visual quick feedback for your tests? Install the Nanoleaf IntelliJ plugin.

The plugin listen to your test suites results, and trigger the Nanoleaf with a predefined color for red bar and green
bar.

Configuration is simple: set the static IP address of your Nanoleaf, an API key, then choose red bar effect and green
bar effect from your Nanoleaf effects list, and do some great TDD!
<!-- Plugin description end -->

![Demo](/assets/demo.gif)

## Installation

- Using IDE built-in plugin system:

  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for
  "nanoleaf-intellij-plugin"</kbd> >
  <kbd>Install Plugin</kbd>

- Manually:

  Download the [latest release](https://github.com/tiste/nanoleaf-intellij-plugin/releases/latest) and install it
  manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
