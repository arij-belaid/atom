package jcanon;

/**
* jcanon/CorbaFireHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /home/vpc/xprojects/games/canon/src/tn/rnu/enit/ateliercorba/jcanon/jcanon.idl
* lundi 15 octobre 2007 19 h 43 CEST
*/

public final class CorbaFireHolder implements org.omg.CORBA.portable.Streamable
{
  public jcanon.CorbaFire value = null;

  public CorbaFireHolder ()
  {
  }

  public CorbaFireHolder (jcanon.CorbaFire initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = jcanon.CorbaFireHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    jcanon.CorbaFireHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return jcanon.CorbaFireHelper.type ();
  }

}
