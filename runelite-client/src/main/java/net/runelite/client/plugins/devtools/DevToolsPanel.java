/*
 * Copyright (c) 2017, Kronos <https://github.com/KronosDesign>
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.plugins.devtools;

import java.awt.Color;
import java.awt.GridLayout;
<<<<<<< HEAD
import javax.inject.Inject;
=======
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.swing.ImageIcon;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
import javax.swing.JButton;
import javax.swing.JPanel;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
<<<<<<< HEAD
import net.runelite.client.ui.ColorScheme;
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
import net.runelite.client.ui.PluginPanel;

@Slf4j
public class DevToolsPanel extends PluginPanel
{
	private final Client client;
	private final DevToolsPlugin plugin;

<<<<<<< HEAD
	private final WidgetInspector widgetInspector;
	private final VarInspector varInspector;

	@Inject
	public DevToolsPanel(Client client, DevToolsPlugin plugin, WidgetInspector widgetInspector, VarInspector varInspector)
=======
	private final VarTracker varTracker;

	private WidgetInspector widgetInspector;

	@Inject
	public DevToolsPanel(Client client, DevToolsPlugin plugin, WidgetInspector widgetInspector)
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	{
		super();
		this.client = client;
		this.plugin = plugin;
		this.widgetInspector = widgetInspector;
<<<<<<< HEAD
		this.varInspector = varInspector;

		setBackground(ColorScheme.DARK_GRAY_COLOR);

=======

		varTracker = new VarTracker(client);
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		add(createOptionsPanel());
	}

	private JPanel createOptionsPanel()
	{
		final JPanel container = new JPanel();
<<<<<<< HEAD
		container.setBackground(ColorScheme.DARK_GRAY_COLOR);
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		container.setLayout(new GridLayout(0, 2, 3, 3));

		final JButton renderPlayersBtn = new JButton("Players");
		renderPlayersBtn.addActionListener(e ->
		{
			highlightButton(renderPlayersBtn);
			plugin.togglePlayers();
		});
		container.add(renderPlayersBtn);

		final JButton renderNpcsBtn = new JButton("NPCs");
		renderNpcsBtn.addActionListener(e ->
		{
			highlightButton(renderNpcsBtn);
			plugin.toggleNpcs();
		});
		container.add(renderNpcsBtn);

		final JButton renderGroundItemsBtn = new JButton("Ground Items");
		renderGroundItemsBtn.addActionListener(e ->
		{
			highlightButton(renderGroundItemsBtn);
			plugin.toggleGroundItems();
		});
		container.add(renderGroundItemsBtn);

		final JButton renderGroundObjectsBtn = new JButton("Ground Objects");
		renderGroundObjectsBtn.addActionListener(e ->
		{
			highlightButton(renderGroundObjectsBtn);
			plugin.toggleGroundObjects();
		});
		container.add(renderGroundObjectsBtn);

		final JButton renderGameObjectsBtn = new JButton("Game Objects");
		renderGameObjectsBtn.addActionListener(e ->
		{
			highlightButton(renderGameObjectsBtn);
			plugin.toggleGameObjects();
		});
		container.add(renderGameObjectsBtn);

		final JButton renderWallsBtn = new JButton("Walls");
		renderWallsBtn.addActionListener(e ->
		{
			highlightButton(renderWallsBtn);
			plugin.toggleWalls();
		});
		container.add(renderWallsBtn);

		final JButton renderDecorBtn = new JButton("Decorations");
		renderDecorBtn.addActionListener(e ->
		{
			highlightButton(renderDecorBtn);
			plugin.toggleDecor();
		});
		container.add(renderDecorBtn);

		final JButton renderInventoryBtn = new JButton("Inventory");
		renderInventoryBtn.addActionListener(e ->
		{
			highlightButton(renderInventoryBtn);
			plugin.toggleInventory();
		});
		container.add(renderInventoryBtn);

		final JButton renderProjectilesBtn = new JButton("Projectiles");
		renderProjectilesBtn.addActionListener(e ->
		{
			highlightButton(renderProjectilesBtn);
			plugin.toggleProjectiles();
		});
		container.add(renderProjectilesBtn);

<<<<<<< HEAD
=======
		final JPanel boundsDebugPanel = createBoundsDebugMultiButton();
		container.add(boundsDebugPanel);

		final JButton varSnapshotBtn = new JButton("Snapshot Vars");
		varSnapshotBtn.addActionListener(varTracker::snapshot);
		container.add(varSnapshotBtn);

		final JButton varClearBtn = new JButton("Clear Vars");
		varClearBtn.addActionListener(varTracker::clear);
		container.add(varClearBtn);

>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		final JButton renderLocationBtn = new JButton("Location");
		renderLocationBtn.addActionListener(e ->
		{
			highlightButton(renderLocationBtn);
			plugin.toggleLocation();
		});
		container.add(renderLocationBtn);

<<<<<<< HEAD
		final JButton widgetInspectorBtn = new JButton("Widget Tools");
=======
		final JButton widgetInspectorBtn = new JButton("Inspector");
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		widgetInspectorBtn.addActionListener(e ->
		{
			widgetInspector.setVisible(true);
			widgetInspector.toFront();
			widgetInspector.repaint();
		});
		container.add(widgetInspectorBtn);

<<<<<<< HEAD
		final JButton varInspectorBtn = new JButton("Var Tools");
		varInspectorBtn.addActionListener(e ->
		{
			varInspector.open();
		});
		container.add(varInspectorBtn);

=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		final JButton chunkBordersBtn = new JButton("Chunk borders");
		chunkBordersBtn.addActionListener(e ->
		{
			highlightButton(chunkBordersBtn);
			plugin.toggleChunkBorders();
		});
		container.add(chunkBordersBtn);

		final JButton mapSquaresBtn = new JButton("Map squares");
		mapSquaresBtn.addActionListener(e ->
		{
			highlightButton(mapSquaresBtn);
			plugin.toggleMapSquares();
		});
		container.add(mapSquaresBtn);

		final JButton validMovementBtn = new JButton("Valid Moves");
		validMovementBtn.addActionListener(e ->
		{
			highlightButton(validMovementBtn);
			plugin.toggleValidMovement();
		});
		container.add(validMovementBtn);

		final JButton lineOfSightBtn = new JButton("Line of Sight");
		lineOfSightBtn.addActionListener(e ->
		{
			highlightButton(lineOfSightBtn);
			plugin.toggleLineOfSight();
		});
		container.add(lineOfSightBtn);

<<<<<<< HEAD
		final JButton graphicsObjectsBtn = new JButton("Graphics objects");
		graphicsObjectsBtn.addActionListener(e ->
		{
			highlightButton(graphicsObjectsBtn);
			plugin.toggleGraphicsObjects();
		});
		container.add(graphicsObjectsBtn);

		final JButton cameraPositionBtn = new JButton("Camera Position");
		cameraPositionBtn.addActionListener(e ->
		{
			highlightButton(cameraPositionBtn);
			plugin.toggleCamera();
		});
		container.add(cameraPositionBtn);

		final JButton worldMapBtn = new JButton("World Map Location");
		worldMapBtn.addActionListener(e ->
		{
			highlightButton(worldMapBtn);
			plugin.toggleWorldMapLocation();
		});
		container.add(worldMapBtn);

		final JButton tileLocationBtn = new JButton("Tile Location Tooltip");
		tileLocationBtn.addActionListener(e ->
		{
			highlightButton(tileLocationBtn);
			plugin.toggleTileLocation();
		});
		container.add(tileLocationBtn);

		final JButton oculusOrbBtn = new JButton("Detached camera");
		oculusOrbBtn.addActionListener(e ->
		{
			highlightButton(oculusOrbBtn);
			client.setOculusOrbState(oculusOrbBtn.getBackground().equals(Color.GREEN) ? 1 : 0);
		});
		container.add(oculusOrbBtn);

		return container;
=======
		return container;
	}

	private JPanel createBoundsDebugMultiButton()
	{
		ImageIcon bBox2DIcon;
		ImageIcon bBox3DIcon;
		ImageIcon clickBoxIcon;
		ImageIcon bBox3DMousoverIcon;

		try
		{
			synchronized (ImageIO.class)
			{
				bBox2DIcon = new ImageIcon(ImageIO.read(DevToolsPlugin.class.getResourceAsStream("2D_bounding_box.png")));
				bBox3DIcon = new ImageIcon(ImageIO.read(DevToolsPlugin.class.getResourceAsStream("3D_bounding_box.png")));
				clickBoxIcon = new ImageIcon(ImageIO.read(DevToolsPlugin.class.getResourceAsStream("2D_clickbox_geometry.png")));
				bBox3DMousoverIcon = new ImageIcon(ImageIO.read(DevToolsPlugin.class.getResourceAsStream("mouseover_3D_bounding_box.png")));
			}
		}
		catch (IOException ex)
		{
			log.warn("unable to load bounding box images", ex);
			return new JPanel();
		}

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 4));
		JButton bBox2DButton = new JButton(bBox2DIcon);
		bBox2DButton.addActionListener(e ->
		{
			client.setDrawBoundingBoxes2D(!client.getDrawBoundingBoxes2D());
			highlightButton(bBox2DButton);
		});
		buttonPanel.add(bBox2DButton);

		JButton bBox3DButton = new JButton(bBox3DIcon);
		bBox3DButton.addActionListener(e ->
		{
			client.setDrawBoundingBoxes3D(!client.getDrawBoundingBoxes3D());
			highlightButton(bBox3DButton);
		});
		buttonPanel.add(bBox3DButton);

		JButton clickBoxButton = new JButton(clickBoxIcon);
		clickBoxButton.addActionListener(e ->
		{
			client.setdrawObjectGeometry2D(!client.getdrawObjectGeometry2D());
			highlightButton(clickBoxButton);
		});
		buttonPanel.add(clickBoxButton);

		JButton mouseoverModeButton = new JButton(client.getBoundingBoxAlwaysOnMode() ? bBox3DIcon : bBox3DMousoverIcon);
		mouseoverModeButton.addActionListener(e ->
		{
			client.setBoundingBoxAlwaysOnMode(!client.getBoundingBoxAlwaysOnMode());
			if (client.getBoundingBoxAlwaysOnMode())
			{
				mouseoverModeButton.setIcon(bBox3DIcon);
			}
			else
			{
				mouseoverModeButton.setIcon(bBox3DMousoverIcon);
			}
		});
		buttonPanel.add(mouseoverModeButton);

		return buttonPanel;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	}

	private void highlightButton(JButton button)
	{
		if (button.getBackground().equals(Color.GREEN))
		{
			button.setBackground(null);
		}
		else
		{
			button.setBackground(Color.GREEN);
		}
	}
}
