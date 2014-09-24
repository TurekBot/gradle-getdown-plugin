package bundles

import org.gradle.api.file.CopySpec

class GetdownPluginExtension {

	/** application title, used for display name (default : project.name)*/
	String title

	/** url of getdown's appbase */
	String appbase

	/** getdown version (default : 'app')*/
	String version

	/** directory where to generate getdown 'website' (default : "${project.buildDir}/getdown") */
	File dest

	/** directory where to place the application (default : "${cfg.dest}/${cfg.version}") */
	File destVersion

	//TODO store a hashtable (pre-configured) that will be used as source to generate getdown.txt
	/** The template used to generate getdown.txt */
	String tmplGetdownTxt

	/** The template used to generate launch (unix launcher script) */
	String tmplScriptUnix

	/** The template used to generate launch.vbs (windows launcher script if launch4j not available) */
	String tmplScriptWindows

	/** The template used to generate the launch4j configuration */
	String tmplLaunch4j

	/**
	 *  The path to the launch4j executable.
	 *
	 *  It can be set via system property 'launch4jCmd' or in ~/.gradle/gradle.properties
	 *  <pre>
	 *  systemProp.launch4jCmd=${System.properties['user.home']}/bin/soft/launch4j/launch4j
	 *  </pre>
	 */
	String launch4jCmd

	/** jre version to deploy, also used by default getdown.txt template to define the jvm min version */
	JreVersion jreVersion = JreTools.current() //new JreVersion(1,8,0,20,26)

	/** the list of platform for jres and native bundles to provide */
	Platform[] platforms = Platform.values()

	/** the directory where to cache downloaded + packaged jre (default $HOME/.cache */
	File jreCacheDir


	/**
	* The fully qualified name of the application's main class.
	*/
	String mainClassName

	/**
	* Array of string arguments to pass to the JVM when running the application
	*/
	Iterable<String> jvmArgs = []

	/**
	* <p>The specification of the contents of the distribution.</p>
	* <p>
	* Use this {@link org.gradle.api.file.CopySpec} to include extra files/resource in the application distribution.
	*/
	CopySpec distSpec
}
