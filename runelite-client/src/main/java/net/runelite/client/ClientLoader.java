/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.client;

import java.applet.Applet;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
import lombok.extern.slf4j.Slf4j;
import net.runelite.http.api.updatecheck.UpdateCheckClient;

@Slf4j
public class ClientLoader
{
<<<<<<< HEAD
	public Applet loadRs(UpdateCheckMode updateMode)
	{
		if (updateMode == UpdateCheckMode.AUTO)
		{
			final UpdateCheckClient updateCheck = new UpdateCheckClient();
			updateMode = updateCheck.isOutdated() ?
				UpdateCheckMode.VANILLA :
				UpdateCheckMode.RUNELITE;
=======
	public Optional<Applet> loadRs(boolean disableUpdateCheck)
	{
		boolean isOutdated = false;

		if (!disableUpdateCheck)
		{
			final UpdateCheckClient updateCheck = new UpdateCheckClient();
			isOutdated = updateCheck.isOutdated();
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		}

		try
		{
<<<<<<< HEAD
			switch (updateMode)
			{
				case RUNELITE:
					return loadRuneLite();
				default:
				case VANILLA:
					return loadVanilla();
				case NONE:
					return null;
			}
=======
			if (isOutdated)
			{
				log.info("RuneLite is outdated - fetching vanilla client");
				return Optional.of(loadVanilla());
			}

			log.debug("RuneLite is up to date");
			return Optional.of(loadRuneLite());
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		}
		catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e)
		{
			if (e instanceof ClassNotFoundException)
			{
				log.error("Unable to load client - class not found. This means you"
					+ " are not running RuneLite with Maven as the injected client"
					+ " is not in your classpath.");
			}

			log.error("Error loading RS!", e);
<<<<<<< HEAD
			System.exit(-1);
			return null;
=======
			return Optional.empty();
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		}
	}

	private Applet loadRuneLite() throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException
	{
		ConfigLoader config = new ConfigLoader();

		config.fetch();

		String initialClass = config.getProperty(ConfigLoader.INITIAL_CLASS).replace(".class", "");

		// the injected client is a runtime scoped dependency
		Class<?> clientClass = this.getClass().getClassLoader().loadClass(initialClass);
		Applet rs = (Applet) clientClass.newInstance();

		rs.setStub(new RSStub(config));

		return rs;
	}

	private Applet loadVanilla() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		ConfigLoader config = new ConfigLoader();

		config.fetch();

		String codebase = config.getProperty(ConfigLoader.CODEBASE);
		String initialJar = config.getProperty(ConfigLoader.INITIAL_JAR);
		String initialClass = config.getProperty(ConfigLoader.INITIAL_CLASS).replace(".class", "");

		URL url = new URL(codebase + initialJar);

		// Must set parent classloader to null, or it will pull from
		// this class's classloader first
		URLClassLoader classloader = new URLClassLoader(new URL[]
<<<<<<< HEAD
			{
				url
			}, null);
=======
		{
			url
		}, null);
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b

		Class<?> clientClass = classloader.loadClass(initialClass);
		Applet rs = (Applet) clientClass.newInstance();

		rs.setStub(new RSStub(config));

		return rs;
	}
}
