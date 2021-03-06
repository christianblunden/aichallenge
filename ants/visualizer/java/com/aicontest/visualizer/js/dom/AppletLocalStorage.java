package com.aicontest.visualizer.js.dom;

import java.applet.Applet;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

public class AppletLocalStorage extends LocalStorage
{
  private static final long serialVersionUID = -3208288476685884199L;
  private sun.plugin.javascript.JSObject storage;

  public AppletLocalStorage(Applet applet)
  {
    try
    {
      storage = ((sun.plugin.javascript.JSObject)sun.plugin.javascript.JSObject.getWindow(applet).getMember("localStorage"));
    }
    catch (Exception e)
    {
    }
  }

  public void put(String name, Scriptable start, Object value) {
    if (storage != null)
      storage.setMember(name, value);
  }

  public Object get(String name, Scriptable start)
  {
    try
    {
      if (storage != null)
        return storage.getMember(name);
    }
    catch (Exception e)
    {
    }
    return Undefined.instance;
  }
}