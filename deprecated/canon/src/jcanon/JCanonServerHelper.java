package jcanon;


/**
* jcanon/JCanonServerHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /home/vpc/xprojects/games/canon/src/tn/rnu/enit/ateliercorba/jcanon/jcanon.idl
* lundi 15 octobre 2007 19 h 43 CEST
*/

abstract public class JCanonServerHelper
{
  private static String  _id = "IDL:tn.rnu.enit.ateliercorba/jcanon/JCanonServer:1.0";

  public static void insert (org.omg.CORBA.Any a, jcanon.JCanonServer that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static jcanon.JCanonServer extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (jcanon.JCanonServerHelper.id (), "JCanonServer");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static jcanon.JCanonServer read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_JCanonServerStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, jcanon.JCanonServer value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static jcanon.JCanonServer narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof jcanon.JCanonServer)
      return (jcanon.JCanonServer)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      jcanon._JCanonServerStub stub = new jcanon._JCanonServerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static jcanon.JCanonServer unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof jcanon.JCanonServer)
      return (jcanon.JCanonServer)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      jcanon._JCanonServerStub stub = new jcanon._JCanonServerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
