using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MoveGun : MonoBehaviour
{
    public float moveSpeed = 2.0f;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        float sides = Input.GetAxis("Horizontal");
        float upDown = Input.GetAxis("Vertical");
        transform.Translate(new Vector3(sides, 0, upDown) * Time.deltaTime * moveSpeed);
        //transform.Rotate(new Vector3(0, sides, 0) * Time.deltaTime * moveSpeed);
    }
}
