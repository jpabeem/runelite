/*
 * Copyright (c) 2017, Cameron <moberg@tuta.io>
<<<<<<< HEAD
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
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
package net.runelite.client.plugins.xptracker;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
<<<<<<< HEAD
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
=======
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.game.SkillIconManager;
<<<<<<< HEAD
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.ui.components.PluginErrorPanel;
import net.runelite.client.util.LinkBrowser;
=======
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.util.StackFormatter;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
import okhttp3.HttpUrl;

@Slf4j
class XpPanel extends PluginPanel
{
	private final Map<Skill, XpInfoBox> infoBoxes = new HashMap<>();
<<<<<<< HEAD

	private final JLabel overallExpGained = new JLabel(XpInfoBox.htmlLabel("Gained: ", 0));
	private final JLabel overallExpHour = new JLabel(XpInfoBox.htmlLabel("Per hour: ", 0));

	private final JPanel overallPanel = new JPanel();

	/* This displays the "No exp gained" text */
	private final PluginErrorPanel errorPanel = new PluginErrorPanel();
=======
	private final JLabel totalXpGained = new JLabel();
	private final JLabel totalXpHr = new JLabel();
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b

	XpPanel(XpTrackerPlugin xpTrackerPlugin, Client client, SkillIconManager iconManager)
	{
		super();

<<<<<<< HEAD
		setBorder(new EmptyBorder(10, 6, 10, 6));
		setBackground(ColorScheme.DARK_GRAY_COLOR);
		setLayout(new BorderLayout());

		final JPanel layoutPanel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(layoutPanel, BoxLayout.Y_AXIS);
		layoutPanel.setLayout(boxLayout);
		add(layoutPanel, BorderLayout.NORTH);

		overallPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		overallPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		overallPanel.setLayout(new BorderLayout());
		overallPanel.setVisible(false); // this will only become visible when the player gets exp

		// Create open xp tracker menu
		final JMenuItem openXpTracker = new JMenuItem("Open online tracker");
		openXpTracker.addActionListener(e -> LinkBrowser.browse(XpPanel.buildXpTrackerUrl(client.getLocalPlayer(), Skill.OVERALL)));

		// Create reset all menu
		final JMenuItem reset = new JMenuItem("Reset All");
		reset.addActionListener(e -> xpTrackerPlugin.resetAndInitState());

		// Create popup menu
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		popupMenu.add(openXpTracker);
		popupMenu.add(reset);
		overallPanel.setComponentPopupMenu(popupMenu);

		final JLabel overallIcon = new JLabel(new ImageIcon(iconManager.getSkillImage(Skill.OVERALL)));

		final JPanel overallInfo = new JPanel();
		overallInfo.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		overallInfo.setLayout(new GridLayout(2, 1));
		overallInfo.setBorder(new EmptyBorder(0, 10, 0, 0));

		overallExpGained.setFont(FontManager.getRunescapeSmallFont());
		overallExpHour.setFont(FontManager.getRunescapeSmallFont());

		overallInfo.add(overallExpGained);
		overallInfo.add(overallExpHour);

		overallPanel.add(overallIcon, BorderLayout.WEST);
		overallPanel.add(overallInfo, BorderLayout.CENTER);


		final JPanel infoBoxPanel = new JPanel();
		infoBoxPanel.setLayout(new BoxLayout(infoBoxPanel, BoxLayout.Y_AXIS));
		layoutPanel.add(overallPanel);
		layoutPanel.add(infoBoxPanel);
=======
		final JPanel layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout(0, 3));
		add(layoutPanel);

		final JPanel totalPanel = new JPanel();
		totalPanel.setLayout(new BorderLayout());
		totalPanel.setBorder(BorderFactory.createLineBorder(getBackground().brighter(), 1, true));

		final JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(4, 1));
		infoPanel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

		final JButton resetButton = new JButton("Reset All");
		resetButton.addActionListener(e -> resetAllInfoBoxes());

		final JButton openTrackerButton = new JButton("Open XP tracker");
		openTrackerButton.addActionListener(e -> LinkBrowser.browse(buildXpTrackerUrl(client.getLocalPlayer(), Skill.OVERALL)));

		totalXpGained.setText(formatLine(0, "total xp gained"));
		totalXpHr.setText(formatLine(0, "total xp/hr"));

		infoPanel.add(totalXpGained);
		infoPanel.add(totalXpHr);
		infoPanel.add(resetButton);
		infoPanel.add(openTrackerButton);
		totalPanel.add(infoPanel, BorderLayout.CENTER);
		layoutPanel.add(totalPanel, BorderLayout.NORTH);

		final JPanel infoBoxPanel = new JPanel();
		infoBoxPanel.setLayout(new BoxLayout(infoBoxPanel, BoxLayout.Y_AXIS));
		layoutPanel.add(infoBoxPanel, BorderLayout.CENTER);
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b

		try
		{
			for (Skill skill : Skill.values())
			{
				if (skill == Skill.OVERALL)
				{
					break;
				}
<<<<<<< HEAD
				infoBoxes.put(skill, new XpInfoBox(xpTrackerPlugin, client, infoBoxPanel, skill, iconManager));
=======

				infoBoxes.put(skill, new XpInfoBox(client, infoBoxPanel, xpTrackerPlugin.getSkillXpInfo(skill), iconManager));
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
			}
		}
		catch (IOException e)
		{
			log.warn(null, e);
		}
<<<<<<< HEAD

		errorPanel.setContent("Exp trackers", "You have not gained experience yet.");
		add(errorPanel);
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	}

	static String buildXpTrackerUrl(final Actor player, final Skill skill)
	{
		if (player == null)
		{
			return "";
		}

		return new HttpUrl.Builder()
			.scheme("https")
			.host("runelite.net")
			.addPathSegment("xp")
			.addPathSegment("show")
			.addPathSegment(skill.getName().toLowerCase())
			.addPathSegment(player.getName())
			.addPathSegment("1week")
			.addPathSegment("now")
			.build()
			.toString();
	}

	void resetAllInfoBoxes()
	{
		infoBoxes.forEach((skill, xpInfoBox) -> xpInfoBox.reset());
<<<<<<< HEAD
	}

	void resetSkill(Skill skill)
	{
		XpInfoBox xpInfoBox = infoBoxes.get(skill);
		if (xpInfoBox != null)
		{
			xpInfoBox.reset();
		}
	}

	void updateSkillExperience(boolean updated, Skill skill, XpSnapshotSingle xpSnapshotSingle)
	{
		final XpInfoBox xpInfoBox = infoBoxes.get(skill);

		if (xpInfoBox != null)
		{
			xpInfoBox.update(updated, xpSnapshotSingle);
		}
	}


	public void updateTotal(XpSnapshotTotal xpSnapshotTotal)
	{
		// if player has gained exp and hasn't switched displays yet, hide error panel and show overall info
		if (xpSnapshotTotal.getXpGainedInSession() > 0 && !overallPanel.isVisible())
		{
			overallPanel.setVisible(true);
			remove(errorPanel);
		}

		SwingUtilities.invokeLater(() -> rebuildAsync(xpSnapshotTotal));
	}

	private void rebuildAsync(XpSnapshotTotal xpSnapshotTotal)
	{
		overallExpGained.setText(XpInfoBox.htmlLabel("Gained: ", xpSnapshotTotal.getXpGainedInSession()));
		overallExpHour.setText(XpInfoBox.htmlLabel("Per hour: ", xpSnapshotTotal.getXpPerHour()));
	}

=======
		updateTotal();
	}

	void updateAllInfoBoxes()
	{
		infoBoxes.forEach((skill, xpInfoBox) -> xpInfoBox.update());
		updateTotal();
	}

	void updateSkillExperience(Skill skill)
	{
		final XpInfoBox xpInfoBox = infoBoxes.get(skill);
		xpInfoBox.update();
		xpInfoBox.init();
		updateTotal();
	}

	private void updateTotal()
	{
		final AtomicInteger totalXpGainedVal = new AtomicInteger();
		final AtomicInteger totalXpHrVal = new AtomicInteger();

		for (XpInfoBox xpInfoBox : infoBoxes.values())
		{
			totalXpGainedVal.addAndGet(xpInfoBox.getXpInfo().getXpGained());
			totalXpHrVal.addAndGet(xpInfoBox.getXpInfo().getXpHr());
		}

		SwingUtilities.invokeLater(() ->
		{
			totalXpGained.setText(formatLine(totalXpGainedVal.get(), "total xp gained"));
			totalXpHr.setText(formatLine(totalXpHrVal.get(), "total xp/hr"));
		});
	}

	static String formatLine(double number, String description)
	{
		String numberStr;
		if (number < 100000)
		{
			numberStr = StackFormatter.formatNumber(number);
		}
		else
		{
			int num = (int) (Math.log(number) / Math.log(1000));
			numberStr = String.format("%.1f%c", number / Math.pow(1000, num), "KMB".charAt(num - 1));
		}

		return numberStr + " " + description;
	}
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
}
