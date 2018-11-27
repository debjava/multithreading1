class MyObject
{
  protected void finalize() throws Throwable
  {
    System.out.println("In finalize method for this object: " + 
                       this);
  }
}

