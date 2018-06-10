/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.config;

import java.awt.Dimension;
import net.runelite.api.Constants;

@ConfigGroup(
	keyName = "runelite",
	name = "RuneLite",
	description = "Configuration for RuneLite client options"
)
public interface RuneLiteConfig extends Config
{
	@ConfigItem(
		keyName = "gameSize",
		name = "Game size",
		description = "The game will resize to this resolution upon starting the client",
<<<<<<< HEAD
		position = 10
=======
		position = 1
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	)
	default Dimension gameSize()
	{
		return Constants.GAME_FIXED_SIZE;
	}

	@ConfigItem(
<<<<<<< HEAD
		keyName = "automaticResizeType",
		name = "Resize type",
		description = "Choose how the window should resize when opening and closing panels",
		position = 11
	)
	default ExpandResizeType automaticResizeType()
	{
		return ExpandResizeType.KEEP_GAME_SIZE;
	}

	@ConfigItem(
		keyName = "lockWindowSize",
		name = "Lock window size",
		description = "Determines if the window resizing is allowed or not",
		position = 12
=======
		keyName = "lockWindowSize",
		name = "Lock window size",
		description = "Determines if the window resizing is allowed or not",
		position = 2
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	)
	default boolean lockWindowSize()
	{
		return false;
	}

	@ConfigItem(
<<<<<<< HEAD
		keyName = "containInScreen",
		name = "Contain in screen",
		description = "Makes the client stay contained in the screen when attempted to move out of it.<br>Note: Only works if custom chrome is enabled.",
		position = 13
	)
	default boolean containInScreen()
	{
		return false;
	}

	@ConfigItem(
		keyName = "rememberScreenBounds",
		name = "Remember client position",
		description = "Save the position and size of the client after exiting",
		position = 14
	)
	default boolean rememberScreenBounds()
	{
		return true;
	}

	@ConfigItem(
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		keyName = "uiEnableCustomChrome",
		name = "Enable custom window chrome",
		description = "Use Runelite's custom window title and borders.",
		warning = "Please restart your client after changing this setting",
<<<<<<< HEAD
		position = 15
=======
		position = 3
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	)
	default boolean enableCustomChrome()
	{
		return true;
	}

	@ConfigItem(
		keyName = "gameAlwaysOnTop",
		name = "Enable client always on top",
		description = "The game will always be on the top of the screen",
<<<<<<< HEAD
		position = 16
=======
		position = 4
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	)
	default boolean gameAlwaysOnTop()
	{
		return false;
	}

	@ConfigItem(
		keyName = "notificationTray",
		name = "Enable tray notifications",
		description = "Enables tray notifications",
<<<<<<< HEAD
		position = 20
=======
		position = 5
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	)
	default boolean enableTrayNotifications()
	{
		return true;
	}

	@ConfigItem(
<<<<<<< HEAD
		keyName = "notificationRequestFocus",
		name = "Request focus on notification",
		description = "Toggles window focus request",
		position = 21
	)
	default boolean requestFocusOnNotification()
	{
		return true;
	}

	@ConfigItem(
		keyName = "notificationSound",
		name = "Enable sound on notifications",
		description = "Enables the playing of a beep sound when notifications are displayed",
		position = 22
=======
		keyName = "notificationSound",
		name = "Enable sound on notifications",
		description = "Enables the playing of a beep sound when notifications are displayed",
		position = 6
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	)
	default boolean enableNotificationSound()
	{
		return true;
	}

	@ConfigItem(
<<<<<<< HEAD
		keyName = "notificationGameMessage",
		name = "Enable game message notifications",
		description = "Puts a notification message in the chatbox",
		position = 23
	)
	default boolean enableGameMessageNotification()
	{
		return false;
	}

	@ConfigItem(
		keyName = "notificationFlash",
		name = "Enable flash notification",
		description = "Flashes the game frame as a notification",
		position = 24
	)
	default boolean enableFlashNotification()
	{
		return false;
	}

	@ConfigItem(
		keyName = "notificationFocused",
		name = "Send notifications when focused",
		description = "Toggles idle notifications for when the client is focused",
		position = 25
=======
		keyName = "notificationFocused",
		name = "Send notifications when focused",
		description = "Toggles idle notifications for when the client is focused",
		position = 7
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	)
	default boolean sendNotificationsWhenFocused()
	{
		return false;
	}

	@ConfigItem(
<<<<<<< HEAD
		keyName = "fontType",
		name = "Dynamic Overlay Font",
		description = "Configures what font type is used for in-game overlays such as player name, ground items, etc.",
		position = 30
	)
	default FontType fontType()
	{
		return FontType.SMALL;
	}

	@ConfigItem(
		keyName = "tooltipFontType",
		name = "Tooltip Font",
		description = "Configures what font type is used for in-game tooltips such as food stats, NPC names, etc.",
		position = 31
	)
	default FontType tooltipFontType()
=======
		keyName = "notificationRequestFocus",
		name = "Request focus on notification",
		description = "Toggles window focus request",
		position = 8
	)
	default boolean requestFocusOnNotification()
	{
		return true;
	}

	@ConfigItem(
		keyName = "fontType",
		name = "Dynamic Overlay Font",
		description = "Configures what font type is used for in-game overlays such as player name, ground items, etc.",
		position = 9
	)
	default FontType fontType()
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	{
		return FontType.SMALL;
	}

	@ConfigItem(
		keyName = "infoBoxVertical",
		name = "Display infoboxes vertically",
		description = "Toggles the infoboxes to display vertically",
<<<<<<< HEAD
		position = 32
=======
		position = 10
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	)
	default boolean infoBoxVertical()
	{
		return false;
	}

	@ConfigItem(
		keyName = "infoBoxWrap",
		name = "Infobox wrap count",
		description = "Configures the amount of infoboxes shown before wrapping",
<<<<<<< HEAD
		position = 33
=======
		position = 11
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	)
	default int infoBoxWrap()
	{
		return 4;
	}
<<<<<<< HEAD
=======

	@ConfigItem(
		keyName = "containInScreen",
		name = "Contain in screen",
		description = "Makes the client stay contained in the screen when attempted to move out of it.<br>Note: Only works if custom chrome is enabled.",
		position = 12
	)
	default boolean containInScreen()
	{
		return false;
	}

	@ConfigItem(
		keyName = "rememberScreenBounds",
		name = "Remember client position",
		description = "Save the position and size of the client after exiting",
		position = 13
	)
	default boolean rememberScreenBounds()
	{
		return true;
	}
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
}