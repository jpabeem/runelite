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
 */
package net.runelite.client.plugins.implings;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
<<<<<<< HEAD
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
=======
import javax.inject.Inject;
import net.runelite.api.Actor;
import net.runelite.api.NPC;
import net.runelite.api.Point;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

/**
<<<<<<< HEAD
=======
 *
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
 * @author robin
 */
public class ImplingsOverlay extends Overlay
{
<<<<<<< HEAD
	private final Client client;
	private final ImplingsConfig config;
	private final ImplingsPlugin plugin;

	@Inject
	private ImplingsOverlay(Client client, ImplingsConfig config, ImplingsPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.config = config;
		this.client = client;
=======
	private final ImplingsPlugin plugin;

	@Inject
	private ImplingsOverlay(ImplingsPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
<<<<<<< HEAD
		List<NPC> implings = plugin.getImplings();

		if (implings.isEmpty())
=======
		NPC[] imps = plugin.getImplings();
		if (imps == null)
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		{
			return null;
		}

<<<<<<< HEAD
		for (NPC imp : implings)
		{
			Color color = plugin.npcToColor(imp);
			if (!plugin.showNpc(imp) || color == null)
=======
		for (NPC imp : imps)
		{
			if (imp == null || imp.getName() == null)
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
			{
				continue;
			}

<<<<<<< HEAD
			drawImp(graphics, imp, imp.getName(), color);
		}

		//Draw static spawns
		if (config.showSpawn())
		{
			for (ImplingSpawn spawn : ImplingSpawn.values())
			{
				if (!plugin.showImplingType(spawn.getType()))
				{
					continue;
				}

				String impName = spawn.getType().getName();
				drawSpawn(graphics, spawn.getSpawnLocation(), impName, config.getSpawnColor());
			}
=======
			//Spawns have the name "null", so they get changed to "Spawn"
			String text = imp.getName().equals("null") ? "Spawn" : imp.getName();
			drawImp(graphics, imp, text, plugin.getIds().get(imp.getId()));
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		}

		return null;
	}

<<<<<<< HEAD
	private void drawSpawn(Graphics2D graphics, WorldPoint point, String text, Color color)
	{
		//Don't draw spawns if Player is not in range
		if (point.distanceTo(client.getLocalPlayer().getWorldLocation()) >= 32)
		{
			return;
		}

		LocalPoint localPoint = LocalPoint.fromWorld(client, point);
		if (localPoint == null)
		{
			return;
		}

		Polygon poly = Perspective.getCanvasTilePoly(client, localPoint);
		if (poly != null)
		{
			OverlayUtil.renderPolygon(graphics, poly, color);
		}

		Point textPoint = Perspective.getCanvasTextLocation(client, graphics, localPoint, text, 0);
		if (textPoint != null)
		{
			OverlayUtil.renderTextLocation(graphics, textPoint, text, color);
		}
	}

=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	private void drawImp(Graphics2D graphics, Actor actor, String text, Color color)
	{
		Polygon poly = actor.getCanvasTilePoly();
		if (poly != null)
		{
			OverlayUtil.renderPolygon(graphics, poly, color);
		}

		Point textLocation = actor.getCanvasTextLocation(graphics, text, actor.getLogicalHeight());
		if (textLocation != null)
		{
			OverlayUtil.renderTextLocation(graphics, textLocation, text, color);
		}
	}

}
