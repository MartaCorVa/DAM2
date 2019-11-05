using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour
{
    private float speed = 5.0f;
    private float turnSpeed = 45.0f;
    private float horizontalInput;
    private float forwardInput;

    // Start is called before the first frame update
    void Start()
    {

    }
    // Update is called once per frame
    void Update()
    {
        //Move the vehicle to the right (D) or to the left (A)
        horizontalInput = Input.GetAxis("Horizontal");
        //Move the vehicle forward (W) or backward (S)
        forwardInput = Input.GetAxis("Vertical");
        // Move the vehicle forward or backward
        transform.Translate(Vector3.forward * Time.deltaTime * speed * forwardInput);
        // Move the vehicle to the right or to the left
        transform.Rotate(Vector3.up, Time.deltaTime * turnSpeed * horizontalInput);
    }
}
