/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.woodcutting;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup(
	keyName = "woodcutting",
	name = "Woodcutting",
	description = "Configuration for the woodcutting plugin"
)
public interface WoodcuttingConfig extends Config
{
	@ConfigItem(
<<<<<<< HEAD
		position = 1,
		keyName = "statTimeout",
		name = "Reset stats (minutes)",
		description = "Configures the time until statistic is reset. Also configures when tree indicator is hidden"
=======
		keyName = "statTimeout",
		name = "Reset stats (minutes)",
		description = "Configures the time until statistic is reset"
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	)
	default int statTimeout()
	{
		return 5;
	}

	@ConfigItem(
<<<<<<< HEAD
		position = 2,
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		keyName = "showNestNotification",
		name = "Bird nest notification",
		description = "Configures whether to notify you of a bird nest spawn"
	)
	default boolean showNestNotification()
	{
		return true;
	}

	@ConfigItem(
<<<<<<< HEAD
		position = 3,
		keyName = "showWoodcuttingStats",
		name = "Show session stats",
=======
		keyName = "showWoodcuttingStats",
		name = "Show Woodcutting session stats",
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		description = "Configures whether to display woodcutting session stats"
	)
	default boolean showWoodcuttingStats()
	{
		return true;
	}
<<<<<<< HEAD

	@ConfigItem(
		position = 4,
		keyName = "showRedwoods",
		name = "Show Redwood trees",
		description = "Configures whether to show a indicator for redwood trees"
	)
	default boolean showRedwoodTrees()
	{
		return true;
	}
}
=======
}
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
