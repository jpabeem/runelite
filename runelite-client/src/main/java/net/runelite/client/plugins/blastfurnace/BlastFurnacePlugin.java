/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.blastfurnace;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.util.Arrays;
import java.util.Collection;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import static net.runelite.api.ObjectID.CONVEYOR_BELT;
<<<<<<< HEAD
import static net.runelite.api.ObjectID.NULL_9092;
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;

@PluginDescriptor(
	name = "Blast Furnace"
)
public class BlastFurnacePlugin extends Plugin
{
<<<<<<< HEAD
	private static final int BAR_DISPENSER = NULL_9092;

	@Getter(AccessLevel.PACKAGE)
	private GameObject conveyorBelt;

	@Getter(AccessLevel.PACKAGE)
	private GameObject barDispenser;

=======
	@Getter(AccessLevel.PACKAGE)
	private GameObject conveyorBelt;

>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	@Inject
	private BlastFurnaceOverlay overlay;

	@Inject
	private BlastFurnaceCofferOverlay cofferOverlay;

	@Inject
<<<<<<< HEAD
	private BlastFurnaceClickBoxOverlay clickBoxOverlay;
=======
	private ConveyorBeltOverlay conveyorBeltOverlay;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b

	@Override
	protected void shutDown()
	{
		conveyorBelt = null;
<<<<<<< HEAD
		barDispenser = null;
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	}

	@Provides
	BlastFurnaceConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BlastFurnaceConfig.class);
	}

	@Override
	public Collection<Overlay> getOverlays()
	{
<<<<<<< HEAD
		return Arrays.asList(overlay, cofferOverlay, clickBoxOverlay);
=======
		return Arrays.asList(overlay, cofferOverlay, conveyorBeltOverlay);
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	}

	@Subscribe
	public void onGameObjectSpawn(GameObjectSpawned event)
	{
		GameObject gameObject = event.getGameObject();
<<<<<<< HEAD

		switch (gameObject.getId())
		{
			case CONVEYOR_BELT:
				conveyorBelt = gameObject;
				break;

			case BAR_DISPENSER:
				barDispenser = gameObject;
				break;
=======
		if (gameObject.getId() == CONVEYOR_BELT)
		{
			conveyorBelt = gameObject;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		}
	}

	@Subscribe
	public void onGameObjectDespawn(GameObjectDespawned event)
	{
		GameObject gameObject = event.getGameObject();
<<<<<<< HEAD

		switch (gameObject.getId())
		{
			case CONVEYOR_BELT:
				conveyorBelt = null;
				break;

			case BAR_DISPENSER:
				barDispenser = null;
				break;
=======
		if (gameObject.getId() == CONVEYOR_BELT)
		{
			conveyorBelt = null;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOADING)
		{
			conveyorBelt = null;
<<<<<<< HEAD
			barDispenser = null;
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		}
	}
}
