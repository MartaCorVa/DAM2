using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BulletCreator : MonoBehaviour
{

    public GameObject projectilePrefabRef;
    public float thrust = 1.0f;
    public float moveSpeed = 2.0f;

    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKeyDown(KeyCode.Mouse0))
        {
            GameObject projectile = Instantiate(projectilePrefabRef, transform.position, Quaternion.identity);
            projectile.GetComponent<Rigidbody>().AddForce(transform.forward * thrust, ForceMode.Impulse);
            Destroy(projectile, 5.0f);

        }
        float sides = Input.GetAxis("Horizontal");
        float upDown = Input.GetAxis("Vertical");
        transform.Translate(new Vector3(sides, 0, upDown) * Time.deltaTime * moveSpeed);
        //transform.Rotate(new Vector3(0, sides, 0) * Time.deltaTime * moveSpeed);

    }
}
