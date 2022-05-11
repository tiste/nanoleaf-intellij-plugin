# nanoleaf-intellij-plugin

[![Build](https://github.com/tiste/nanoleaf-intellij-plugin/actions/workflows/build.yml/badge.svg)](https://github.com/tiste/nanoleaf-intellij-plugin/actions/workflows/build.yml)
[![Version](https://img.shields.io/jetbrains/plugin/v/19134.svg)](https://plugins.jetbrains.com/plugin/19134)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/19134.svg)](https://plugins.jetbrains.com/plugin/19134)

<!-- Plugin description -->
Want fancy coloured and visual quick feedback for your tests? Install the Nanoleaf IntelliJ plugin.

The plugin listen to your test suites results, and trigger the Nanoleaf with a predefined color for red bar and green
bar.

Configuration is simple: set the static IP address of your Nanoleaf, an API key, then choose red bar effect and green
bar effect from your Nanoleaf effects list, and do some great TDD!
<!-- Plugin description end -->

<p align="center">
  <a href="https://www.youtube.com/watch?v=zZb3pJ2FtMg">
    <img src="/assets/demo.gif" alt="Demo" />
  </a>
</p>

## Installation

- Using IDE built-in plugin system:

  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for
  "nanoleaf-intellij-plugin"</kbd> >
  <kbd>Install Plugin</kbd>

- Manually:

  Download the [latest release](https://github.com/tiste/nanoleaf-intellij-plugin/releases/latest) and install it
  manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

## Configuration

![Settings](/assets/settings.png)

1. Add your Nanoleaf IP address
2. Ask or paste your API key
   1. To get a new API key, you have to set the Nanoleaf in "discovery" mode (press the power button for 7 seconds)
3. Select one of your preferred effects for red/green bar
4. Enjoy!

---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
