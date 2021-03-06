<<<<<<< HEAD
/*
 * Copyright (c) 2017, Robin <robin.weymans@gmail.com>
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
=======
/* 
 * Copyright (c) 2017, Robin <robin.weymans@gmail.com> 
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
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
 */
package net.runelite.client.plugins.implings;

import com.google.common.eventbus.Subscribe;
<<<<<<< HEAD
import com.google.inject.Provides;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.GameState;
import net.runelite.api.NPC;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
=======
import com.google.common.primitives.Ints;
import com.google.inject.Provides;
import java.awt.Color;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.queries.NPCQuery;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.QueryRunner;

/**
<<<<<<< HEAD
=======
 *
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
 * @author robin
 */
@PluginDescriptor(
	name = "Implings"
)
public class ImplingsPlugin extends Plugin
{
<<<<<<< HEAD
	@Getter(AccessLevel.PACKAGE)
	private final List<NPC> implings = new ArrayList<>();
=======
	// Impling spawns in PuroPuro. Not in NpcID.
	private static final int STATIC_SPAWN = 1618;
	private static final int DYNAMIC_SPAWN = 1633;

	@Getter(AccessLevel.PACKAGE)
	private NPC[] implings;

	@Getter(AccessLevel.PACKAGE)
	private final Map<Integer, Color> ids = new HashMap<>();
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b

	@Inject
	private ImplingsOverlay overlay;

	@Inject
	private ImplingMinimapOverlay minimapOverlay;

	@Inject
	private ImplingsConfig config;

	@Inject
	private QueryRunner queryRunner;

	@Provides
	ImplingsConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ImplingsConfig.class);
	}

	@Override
<<<<<<< HEAD
=======
	protected void startUp() throws Exception
	{
		// Initialize overlay config
		updateConfig();
	}

	@Override
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	public Collection<Overlay> getOverlays()
	{
		return Arrays.asList(overlay, minimapOverlay);
	}

	@Subscribe
<<<<<<< HEAD
	public void onNpcSpawned(NpcSpawned npcSpawned)
	{
		NPC npc = npcSpawned.getNpc();
		Impling impling = Impling.findImpling(npc.getId());

		if (impling != null)
		{
			implings.add(npc);
		}
	}

	@Subscribe
	public void onGameStateChange(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGIN_SCREEN || event.getGameState() == GameState.HOPPING)
		{
			implings.clear();
		}
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned)
	{
		if (implings.isEmpty())
		{
			return;
		}

		NPC npc = npcDespawned.getNpc();
		implings.remove(npc);
	}

	boolean showNpc(NPC npc)
	{
		Impling impling = Impling.findImpling(npc.getId());
		if (impling == null)
		{
			return false;
		}

		return showImplingType(impling.getImplingType());
	}

	boolean showImplingType(ImplingType implingType)
	{
		switch (implingType)
		{
			case BABY:
				return config.showBaby();
			case YOUNG:
				return config.showYoung();
			case GOURMET:
				return config.showGourmet();
			case EARTH:
				return config.showEarth();
			case ESSENCE:
				return config.showEssence();
			case ECLECTIC:
				return config.showEclectic();
			case NATURE:
				return config.showNature();
			case MAGPIE:
				return config.showMagpie();
			case NINJA:
				return config.showNinja();
			case DRAGON:
				return config.showDragon();
			case LUCKY:
				return config.showLucky();
			default:
				return false;
		}
	}

	Color npcToColor(NPC npc)
	{
		Impling impling = Impling.findImpling(npc.getId());
		if (impling == null)
		{
			return null;
		}

		switch (impling.getImplingType())
		{

			case BABY:
				return config.getBabyColor();
			case YOUNG:
				return config.getYoungColor();
			case GOURMET:
				return config.getGourmetColor();
			case EARTH:
				return config.getEarthColor();
			case ESSENCE:
				return config.getEssenceColor();
			case ECLECTIC:
				return config.getEclecticColor();
			case NATURE:
				return config.getNatureColor();
			case MAGPIE:
				return config.getMagpieColor();
			case NINJA:
				return config.getNinjaColor();
			case DRAGON:
				return config.getDragonColor();
			case LUCKY:
				return config.getLuckyColor();
			default:
				return null;
		}
	}
=======
	public void updateConfig(ConfigChanged event)
	{
		updateConfig();
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		NPCQuery implingQuery = new NPCQuery()
			.idEquals(Ints.toArray(ids.keySet()));
		implings = queryRunner.runQuery(implingQuery);
	}

	public void updateConfig()
	{
		ids.clear();
		if (config.showBaby())
		{
			ids.put(NpcID.BABY_IMPLING, config.getBabyColor());
			ids.put(NpcID.BABY_IMPLING_1645, config.getBabyColor());
		}
		if (config.showYoung())
		{
			ids.put(NpcID.YOUNG_IMPLING, config.getYoungColor());
			ids.put(NpcID.YOUNG_IMPLING_1646, config.getYoungColor());
		}
		if (config.showGourmet())
		{
			ids.put(NpcID.GOURMET_IMPLING, config.getGourmetColor());
			ids.put(NpcID.GOURMET_IMPLING_1647, config.getGourmetColor());
		}
		if (config.showEarth())
		{
			ids.put(NpcID.EARTH_IMPLING, config.getEarthColor());
			ids.put(NpcID.EARTH_IMPLING_1648, config.getEarthColor());
		}
		if (config.showEssence())
		{
			ids.put(NpcID.ESSENCE_IMPLING, config.getEssenceColor());
			ids.put(NpcID.ESSENCE_IMPLING_1649, config.getEssenceColor());
		}
		if (config.showEclectic())
		{
			ids.put(NpcID.ECLECTIC_IMPLING, config.getEclecticColor());
			ids.put(NpcID.ECLECTIC_IMPLING_1650, config.getEclecticColor());
		}
		if (config.showNature())
		{
			ids.put(NpcID.NATURE_IMPLING, config.getNatureColor());
			ids.put(NpcID.NATURE_IMPLING_1651, config.getNatureColor());
		}
		if (config.showMagpie())
		{
			ids.put(NpcID.MAGPIE_IMPLING, config.getMagpieColor());
			ids.put(NpcID.MAGPIE_IMPLING_1652, config.getMagpieColor());
		}
		if (config.showNinja())
		{
			ids.put(NpcID.NINJA_IMPLING, config.getNinjaColor());
			ids.put(NpcID.NINJA_IMPLING_1653, config.getNinjaColor());
		}
		if (config.showDragon())
		{
			ids.put(NpcID.DRAGON_IMPLING, config.getDragonColor());
			ids.put(NpcID.DRAGON_IMPLING_1654, config.getDragonColor());
		}
		if (config.showLucky())
		{
			ids.put(NpcID.LUCKY_IMPLING, config.getLuckyColor());
			ids.put(NpcID.LUCKY_IMPLING_7302, config.getLuckyColor());
		}
		if (config.showSpawn())
		{
			ids.put(STATIC_SPAWN, config.getSpawnColor());
			ids.put(DYNAMIC_SPAWN, config.getSpawnColor());
		}
	}

>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
}
