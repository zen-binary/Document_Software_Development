/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI9_GENERIC;

/**
 *
 * @author Dungna89
 */
public class S2_Service<T> implements S2_IService<T> {

  private T[] arrT;

  public S2_Service(T[] arrT) {
    this.arrT = arrT;
  }

  @Override
  public boolean checkSoChan(T obj) {
    if (Integer.parseInt(obj.toString()) % 2 == 0) {
      return true;
    }

    return false;
  }

}
