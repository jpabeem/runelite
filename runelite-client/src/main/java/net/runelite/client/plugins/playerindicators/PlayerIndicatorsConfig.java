/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.playerindicators;

import java.awt.Color;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "playerindicators",
	name = "Player Indicators",
	description = "Configuration for the player indicators plugin"
)
public interface PlayerIndicatorsConfig extends Config
{
	@ConfigItem(
		position = 0,
		keyName = "drawOwnName",
<<<<<<< HEAD
		name = "Highlight own player",
		description = "Configures whether or not your own player should be highlighted"
	)
	default boolean highlightOwnPlayer()
=======
		name = "Draw own name",
		description = "Configures whether or not own name should be drawn"
	)
	default boolean drawOwnName()
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	{
		return false;
	}

	@ConfigItem(
		position = 1,
		keyName = "ownNameColor",
<<<<<<< HEAD
		name = "Own player color",
		description = "Color of your own player"
	)
	default Color getOwnPlayerColor()
=======
		name = "Own name color",
		description = "Color of your own name"
	)
	default Color getOwnNameColor()
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	{
		return new Color(0, 184, 212);
	}

	@ConfigItem(
		position = 2,
		keyName = "drawFriendNames",
<<<<<<< HEAD
		name = "Highlight friends",
		description = "Configures whether or not friends should be highlighted"
	)
	default boolean highlightFriends()
=======
		name = "Draw friend names",
		description = "Configures whether or not names of player friends should be drawn"
	)
	default boolean drawFriendNames()
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	{
		return true;
	}

	@ConfigItem(
		position = 3,
		keyName = "friendNameColor",
<<<<<<< HEAD
		name = "Friend color",
		description = "Color of friend names"
	)
	default Color getFriendColor()
=======
		name = "Friend name color",
		description = "Color of friend names"
	)
	default Color getFriendNameColor()
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	{
		return new Color(0, 200, 83);
	}

	@ConfigItem(
		position = 4,
		keyName = "drawClanMemberNames",
<<<<<<< HEAD
		name = "Highlight clan members",
		description = "Configures whether or clan members should be highlighted"
=======
		name = "Draw clan member names",
		description = "Configures whether or not names of player's clan members should be drawn"
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	)
	default boolean drawClanMemberNames()
	{
		return true;
	}

	@ConfigItem(
		position = 5,
		keyName = "clanMemberColor",
		name = "Clan member color",
<<<<<<< HEAD
		description = "Color of clan members"
=======
		description = "Color of clan member names"
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	)
	default Color getClanMemberColor()
	{
		return new Color(170, 0, 255);
	}

	@ConfigItem(
		position = 6,
		keyName = "drawTeamMemberNames",
<<<<<<< HEAD
		name = "Highlight team members",
		description = "Configures whether or not team members should be highlighted"
	)
	default boolean highlightTeamMembers()
=======
		name = "Draw team member names",
		description = "Configures whether or not names of player's team members should be drawn"
	)
	default boolean drawTeamMemberNames()
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	{
		return true;
	}

	@ConfigItem(
		position = 7,
		keyName = "teamMemberColor",
		name = "Team member color",
<<<<<<< HEAD
		description = "Color of team members"
=======
		description = "Color of team member names"
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	)
	default Color getTeamMemberColor()
	{
		return new Color(19, 110, 247);
	}

	@ConfigItem(
		position = 8,
		keyName = "drawNonClanMemberNames",
<<<<<<< HEAD
		name = "Highlight non-clan members",
		description = "Configures whether or not non-clan members should be highlighted"
	)
	default boolean highlightNonClanMembers()
=======
		name = "Draw non-clan member names",
		description = "Configures whether or not names of non-clan members should be drawn"
	)
	default boolean drawNonClanMemberNames()
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	{
		return false;
	}

	@ConfigItem(
		position = 9,
		keyName = "nonClanMemberColor",
		name = "Non-clan member color",
		description = "Color of non-clan member names"
	)
	default Color getNonClanMemberColor()
	{
		return Color.RED;
	}

	@ConfigItem(
		position = 10,
		keyName = "drawPlayerTiles",
<<<<<<< HEAD
		name = "Draw tiles under players",
		description = "Configures whether or not tiles under highlighted players should be drawn"
=======
		name = "Draw tiles",
		description = "Configures whether or not tiles under players with rendered names should be drawn"
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	)
	default boolean drawTiles()
	{
		return false;
	}

	@ConfigItem(
		position = 11,
		keyName = "drawOverheadPlayerNames",
		name = "Draw names above players",
		description = "Configures whether or not player names should be drawn above players"
	)
	default boolean drawOverheadPlayerNames()
	{
		return true;
	}

	@ConfigItem(
		position = 12,
		keyName = "drawMinimapNames",
		name = "Draw names on minimap",
		description = "Configures whether or not minimap names for players with rendered names should be drawn"
	)
	default boolean drawMinimapNames()
	{
		return false;
	}

	@ConfigItem(
		position = 13,
		keyName = "colorPlayerMenu",
<<<<<<< HEAD
		name = "Colorize player menu",
=======
		name = "Color player menu",
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		description = "Color right click menu for players"
	)
	default boolean colorPlayerMenu()
	{
		return true;
	}

	@ConfigItem(
		position = 14,
		keyName = "clanMenuIcons",
<<<<<<< HEAD
		name = "Show clan ranks",
		description = "Add clan rank to right click menu and next to player names"
	)
	default boolean showClanRanks()
=======
		name = "Show clan rank in menu",
		description = "Add clan rank to right click menu for players"
	)
	default boolean clanMenuIcons()
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	{
		return true;
	}
}
