using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BookTouchByPlayer : MonoBehaviour
{
    private GameObject player;

    private void OnCollisionEnter(Collision collision)
    {
        
        if (collision.gameObject.name == player.name)
        {
            this.transform.localScale = new Vector3(gameObject.transform.localScale.x / 2, gameObject.transform.localScale.y / 2, gameObject.transform.localScale.z / 2);
        }
    }
}
