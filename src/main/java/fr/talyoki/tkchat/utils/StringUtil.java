package fr.talyoki.tkchat.utils;

import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.Collection;

public class StringUtil
{
	/**
	 * Copies all elements from the iterable collection of originals to the
	 * collection provided.
	 *
	 * @param <T>        the collection of strings
	 * @param token      String to search for
	 * @param originals  An iterable collection of strings to filter.
	 * @param collection The collection to add matches to
	 * @return the collection provided that would have the elements copied
	 * into
	 * @throws UnsupportedOperationException if the collection is immutable
	 *                                       and originals contains a string which starts with the specified
	 *                                       search string.
	 * @throws IllegalArgumentException      if any parameter is is null
	 * @throws IllegalArgumentException      if originals contains a null element.
	 *                                       <b>Note: the collection may be modified before this is thrown</b>
	 */

	public static <T extends Collection<? super String>> T copyPartialMatches(final String token, final Iterable<String> originals, final T collection)
			throws UnsupportedOperationException, IllegalArgumentException
	{

		for(String string : originals)
		{
			if(startsWithIgnoreCase(string, token))
			{
				collection.add(string);
			}
		}

		return collection;
	}

	public static <T extends Collection<? super ProxiedPlayer>> T getPartialMatchesPlayer(final String token, final Collection<ProxiedPlayer> originals, final T collection)
			throws UnsupportedOperationException, IllegalArgumentException
	{

		for(ProxiedPlayer player : originals)
		{
			if(startsWithIgnoreCase(player.getName(), token))
			{
				collection.add(player);
			}
		}

		return collection;
	}

	/**
	 * This method uses a region to check case-insensitive equality. This
	 * means the internal array does not need to be copied like a
	 * toLowerCase() call would.
	 *
	 * @param string String to check
	 * @param prefix Prefix of string to compare
	 * @return true if provided string starts with, ignoring case, the prefix
	 * provided
	 * @throws NullPointerException     if prefix is null
	 * @throws IllegalArgumentException if string is null
	 */
	public static boolean startsWithIgnoreCase(final String string, final String prefix) throws IllegalArgumentException, NullPointerException
	{

		if(string.length() < prefix.length())
		{
			return false;
		}
		return string.regionMatches(true, 0, prefix, 0, prefix.length());
	}
}
